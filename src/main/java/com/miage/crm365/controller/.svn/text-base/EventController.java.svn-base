package com.miage.crm365.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.miage.crm365.model.entity.EventParameter;
import com.miage.crm365.model.entity.EventType;
import com.miage.crm365.model.factory.IEventParameterFactory;
import com.miage.crm365.model.factory.IEventTypeFactory;
import com.miage.crm365.model.service.IEventAllImportFromCsvService;
import com.miage.crm365.model.service.IEventService;
import com.miage.crm365.model.service.IMessageI18nService;
import com.miage.crm365.utils.CRM365Constants;
import com.miage.crm365.utils.ValidationUtil;

/**
 * Controller qui va gerer tout ce qui se ratache au evenements CRM365
 *
 * @version 2.0
 * @author Tarik DJEBIEN
 */
@Controller
@RequestMapping(value = "*.event")
@Scope(value = "singleton")
public class EventController {


	@Resource(name = "eventTypeFactory")
	private IEventTypeFactory eventTypeFactory;

	@Resource(name = "eventParameterFactory")
	private IEventParameterFactory eventParameterFactory;

	@Resource(name = "eventService")
	private IEventService eventService;

	@Resource(name = "eventAllImportFromCsvService")
	private IEventAllImportFromCsvService fileReaderService  ;

	@Resource(name = "messageI18nService")
	private IMessageI18nService i18nService;

	/**
	 * Acces depuis menu
	 * @param model
	 * @return
	 */
	@RequestMapping("/configuration")
	public String goToEventGroupManual(ModelMap model) {
		privLoadEventTypes(model);

		return CRM365Constants.VIEW_EVENT_MGT;
	}



	/**
	 * Methode permettant d'inserer les evenements et parametres dans les tables
	 * correspondantes, via un fichier csv
	 * @param model
	 * @return la vue permettant l'import du csv
	 */
	@RequestMapping(value = "/manualFileInput")
	public String processUpload(ModelMap model){
        List<String> files = fileReaderService.getAllEventTypeNameFromDataBase();

        model.put("files", files);
		return CRM365Constants.VIEW_EVENT_FILE_INPUT;
	}




	/**
	 * Gestion du formulaire de creation d'Event Type
	 * @param httpServletRequest la requete HTTP
	 * @param model le model MVC
	 * @param createEventTypeName le nom de l'event type
	 * @param createEventTypeDescription sa description
	 * @return la page d'acceuil
	 * @author tarik
	 */
	@RequestMapping(value = "/createEventType", method = RequestMethod.POST)
	public String createEventType(HttpServletRequest httpServletRequest, ModelMap model,
			@RequestParam(value = "createEventTypeName", required = true) String createEventTypeName,
			@RequestParam(value = "createEventTypeDescription", required = true) String createEventTypeDescription
			) {

		String statusServiceMessage = null;

		//Create EventType
		if (ValidationUtil.isValid(createEventTypeName) && ValidationUtil.isValid(createEventTypeDescription)) {
			EventType eventType = this.eventTypeFactory.createEventType();
			this.eventTypeFactory.setAll(eventType, createEventTypeName, createEventTypeDescription);

			//Insert or update event
			statusServiceMessage = this.eventService.saveEventType(eventType);
		} else {
			String errorEventTypeStatus = i18nService.getMessage("feedForms", null, null);
			model.put("errorEventTypeStatus",errorEventTypeStatus);
		}

		privLoadEventTypes(model);
		//return state success / failed
		model.put("createEventTypeStatus", statusServiceMessage);
		// Redirection view
		return CRM365Constants.VIEW_EVENT_MGT;
	}


	/**
	 * Gestion du formulaire de creation d'Event Parameter
	 * @param model
	 * @return la page d'acceuil
	 * @author tarik Djebien
	 */
	@RequestMapping(value = "/saveEventParameter", method = RequestMethod.POST)
	public String createEventParameter(HttpServletRequest httpServletRequest, ModelMap model,
			@RequestParam(value = "eventChoice", required = false) String eventChoice,
			@RequestParam(value = "eventParameterName[]", required = true) String[] eventParameterNames,
			@RequestParam(value = "eventParameterValue[]", required = true) String[] eventParameterValues
			) {
		//Statut message de retour du service de sauvegarde des valeurs de params
		StringBuilder statusServiceMessage = new StringBuilder();

		//Structure de donnees stockant les eventParameter a inserer en base
		List<EventParameter> listeEventParametersToAdd = new ArrayList<EventParameter>();
		List<String> names = Arrays.asList(eventParameterNames);
		List<String> descs = Arrays.asList(eventParameterValues);

		//On recupere la PK correspondant au event type selectionne
		Long typeId = eventService.findTechnicalIdByEventTypeName(eventChoice);
		EventParameter eventParameter;

		String name = null;
		String desc = null;
		for (int i=0; i < names.size(); i++) {
			name = names.get(i);
			desc = descs.get(i);
			if (ValidationUtil.isValid( name ) && ValidationUtil.isValid( desc ) ) {
				eventParameter = eventParameterFactory.createEventParameter();
				eventParameterFactory.setAll(eventParameter, name, desc, typeId);
				//puis on insere alors l'eventParameter valide dans notre structure
				listeEventParametersToAdd.add(eventParameter);
			} else {
				//Sinon en cas d'invalidite on ne l'insere pas et on le notifie
				model.put("infoUnsetParameters", i18nService.getMessage("feedForms", null, null));
			}
		}

		//Finalement on insere tous les nouveaux enregistrements en deleguant le traitement au service d'event
		statusServiceMessage.append(eventService.saveAllEvent(listeEventParametersToAdd));

		//return state result (success / failed )
		String createEventParameterStatus = statusServiceMessage.toString();
		//in the model.
		model.put("createEventParameterStatus", createEventParameterStatus);
		privLoadEventTypes(model);

		//Dans les deux situations, on redirige vers la meme vue
		return CRM365Constants.VIEW_EVENT_MGT;
	}


	private void privLoadEventTypes(ModelMap model) {
		List<EventType> availableEventType = this.eventService.getAllEventTypes();

		//Retour du service
		if(availableEventType.isEmpty() || availableEventType==null) {
			String eventTypesUnavailable = i18nService.getMessage("noEvents", null, null);
			model.put("eventTypesUnavailable", eventTypesUnavailable);
		}

		//Modification du modele pour affichage dans la liste deroulantes
		model.put("eventTypesAvailable", availableEventType);
		//Add events configuration
		model.put("eventsConfiguration", eventService.getEventConfiguration());
	}




    /**
     * Methode permettant d'inserer les evenements et parametres dans la bdd
     * @return resultat des insertions
     * @throws IOException
     */
    @RequestMapping(value = "/uploadEventsFromCsv",method = RequestMethod.POST)
    public String uploadEventsFromCsv(ModelMap model,@RequestParam  MultipartFile file) throws IOException{
    	File temp = File.createTempFile(file.getOriginalFilename() ,"xxxxx");
    	file.transferTo(temp);
    	String path = temp.getAbsolutePath() ;
      	int nbRowInserted = fileReaderService.saveEventsAndEventParameterValueFromFile(path);
      	System.out.println(" lige 1serer " + nbRowInserted );
  		model.put("nbRowInsertedEvent", nbRowInserted);
    	temp.delete();
		return CRM365Constants.VIEW_HOME;
    }




	/**
	 * Methode permettant d'inserer les evenements et parametres dans la bdd
	 * @return resultat des insertions
	 * @throws ServletRequestBindingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/downloadTemplateEvent", method = RequestMethod.GET)
	public String downloadTemplateEvent(
			HttpServletResponse response,
			ModelMap model,
			@RequestParam(value = "userTypeName", required = true) String userTypeName) {
		File fileTemplateEvent;
		try {
			fileTemplateEvent = fileReaderService.createEventTypeAndParameterFileTemplate(userTypeName);
			response.setHeader("Content-Disposition", "attachment; filename=\""+ fileTemplateEvent.getName() + "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType("text/plain; charset=utf-8");
			FileInputStream fileInputStream = new FileInputStream(fileTemplateEvent);
			IOUtils.copy(fileInputStream, out);
			out.flush();
			out.close();
		} catch (IOException e) {
			return null;
		}
		return null;
	}

}
