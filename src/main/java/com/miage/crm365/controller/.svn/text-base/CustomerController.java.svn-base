package com.miage.crm365.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.miage.crm365.model.entity.Customer;
import com.miage.crm365.model.entity.CustomerAlias;
import com.miage.crm365.model.service.ICustomerAliasService;
import com.miage.crm365.model.service.ICustomerFileInputService;
import com.miage.crm365.model.service.ICustomerService;
import com.miage.crm365.utils.CRM365Constants;

/**
 * Controller en ce qui concerne les clients : recherche de clients
 * et import de client via un fichier (csv)
 * @version 1.0
 * @author Antoine CRASKE
 * @author Eric RAKOTOBE
 */
@Controller
@RequestMapping(value = "*.customer")
@Scope(value = "singleton")
public class CustomerController {



	@Resource(name = "customerService")
	private ICustomerService customerService;

	@Resource(name = "customerFileInputService")
	private ICustomerFileInputService customerFileInputService  ;

	@Resource(name = "customerAliasService")
	private ICustomerAliasService customerAliasService;


	private void initModelToRender(ModelMap model){
		List<CustomerAlias> allCustomerAlias = customerAliasService.getAllCustomerAlias();
		int sizeAllCustomerAlias = allCustomerAlias.size();
		model.put("allCustomerAlias",  allCustomerAlias);
		model.put("sizeAllCustomerAlias",  sizeAllCustomerAlias);
	}


	/**
	 * Methode permettant d'inserer les evenements et parametres dans les tables
	 * correspondantes, via un fichier csv
	 * @param model
	 * @return la vue permettant l'import du csv
	 */
	@RequestMapping(value = "/manualFileInput")
	public String processUpload(ModelMap model){

		return CRM365Constants.VIEW_CUSTOMER_FILE_INPUT;
	}


	/**
	 * Methode permettant de retourner la vue de parametrage des alias
	 * pour la customisation des profils clients
	 * @param model
	 * @return la vue permettant l'insertion des alias dans la table Customer_alias via la jsp
	 */
	@RequestMapping(value = "/configuration")
	public String configurationCustomerPage(ModelMap model){
		initModelToRender(model);
		return CRM365Constants.VIEW_CUSTOMER_CUSTOMIZATION;
	}



	@RequestMapping(value = "/searchForm", method = RequestMethod.POST)
	public String eventReport(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "searchInput", required = true) Object searchInput)  {
		List<Customer> customers;

		customers = customerService.getCustomerBy(searchInput);

		model.put("noResult", customers.isEmpty());
		model.put("customers",  customers);

		return CRM365Constants.VIEW_CUSTOMER_SEARCH;
	}



	@RequestMapping(value = "/customerDetail", method = RequestMethod.POST)
	public String eventReport(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "customerId", required = true) Long customerId)  {
		Customer customer;
		customer = customerService.getCustomerById(customerId);
		model.put("customer", customer);

		loadCustomerAlias(model, customer);

		return CRM365Constants.VIEW_CUSTOMER_DETAIL;
	}


	private void loadCustomerAlias(ModelMap model, Customer customer) {
		List<CustomerAlias> allCustomerAlias = customerAliasService.getAllCustomerAlias();
		model.put("allCustomerAlias", allCustomerAlias);

		Map<String,String> freeValMapValue = customerService.generateMapCorrespondance(customer , allCustomerAlias);
		model.put("freeValMapValue", freeValMapValue);
	}



    /**
     * Methode permettant d'inserer les evenements et parametres dans la bdd
     * @return resultat des insertions
     * @throws IOException
     */
    @RequestMapping(value = "/uploadCustomerFromCsv",method = RequestMethod.POST)
    public String uploadEventsFromCsv(ModelMap model,@RequestParam  MultipartFile file) throws IOException{
    	File temp = File.createTempFile(file.getOriginalFilename() ,"xxxxx");
    	file.transferTo(temp);
    	String path = temp.getAbsolutePath() ;
      	int nbRowInserted = customerFileInputService.saveAllCustomersInFile(path);
  		model.put("nbRowInsertedCustomer", nbRowInserted);
    	temp.delete();
		return CRM365Constants.VIEW_HOME;
    }


    
    

    /**
     * Methode permettant de downloader un fichier depuis le serveur vers le client
     * Ce fichier aura comme contenu un en-tete type pour l'upload de fichier Customers
     * @return null car le fichier sera telecharger directement sans passer par 
     * aucune autre vue inutile
     */    
	@RequestMapping(value = "/downloadCustomerTemplate", method = RequestMethod.GET)
	public String downloadCustomerTemplate(HttpServletResponse response , ModelMap model,
			@RequestParam(value = "customerFile", required = true) String userTypeName){
		File fileTemplateCustomer;
		try {
			fileTemplateCustomer = customerFileInputService.createCustomerFileTemplate();
			response.setHeader("Content-Disposition", "attachment; filename=\""+ fileTemplateCustomer.getName() + "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType("text/plain; charset=utf-8");
			FileInputStream fileInputStream = new FileInputStream(
					fileTemplateCustomer);
			IOUtils.copy(fileInputStream, out);
			out.flush();
			out.close();
		} catch (IOException e) {
			return null ; 
		}
		return null ; 
	}
    
    
    
    

    /**
     * Methode permettant de sauvegarder les customeralias issus
     * du formulaire de profi customization
     * @return vue VIEW_CUSTOMER_CUSTOMIZATION
     */
	@RequestMapping(value = "/saveCustomerAlias", method = RequestMethod.POST)
	public String saveCustomerAlias(HttpServletRequest httpServletRequest, ModelMap model,
			@RequestParam(value = "idCustomerAlias[]", required = true) String[] idCustomerAlias,
			@RequestParam(value = "freeValName[]", required = true) String[] freeValName,
			@RequestParam(value = "freeValAlias[]", required = true) String[] freeValAlias
			) {

		List<String> listIdCustomerAlias = Arrays.asList(idCustomerAlias);
		List<String> listFreeValName = Arrays.asList(freeValName);
		List<String> listFreeValAlias = Arrays.asList(freeValAlias);

		for (int i=0; i < listIdCustomerAlias.size(); i++) {
			CustomerAlias customerAlias = new CustomerAlias();
			customerAlias.setIdCustomerAlias(new Long(listIdCustomerAlias.get(i)));
			customerAlias.setFreeValName(listFreeValName.get(i));
			customerAlias.setFreeValAlias(listFreeValAlias.get(i));

			customerAliasService.save(customerAlias);
		}
		initModelToRender(model);
		return CRM365Constants.VIEW_CUSTOMER_CUSTOMIZATION;
	}



    /**
     * Methode permettant de sauvegarder les customeralias issus
     * du formulaire de profi customization
     * @return vue VIEW_CUSTOMER_CUSTOMIZATION
     * @throws IOException
     */
	@RequestMapping(value = "/updateCustomerAlias", method = RequestMethod.POST)
	public String updateCustomerAlias(HttpServletRequest httpServletRequest, ModelMap model,
			@RequestParam(value = "idCustomerAlias", required = true) String idCustomerAlias,
			@RequestParam(value = "freeValName", required = true) String freeValName,
			@RequestParam(value = "freeValAlias", required = true) String freeValAlias
			) {

		CustomerAlias customerAlias = new CustomerAlias();
		customerAlias.setIdCustomerAlias(new Long(idCustomerAlias));
		customerAlias.setFreeValName(freeValName);
		customerAlias.setFreeValAlias(freeValAlias);
		customerAliasService.save(customerAlias);

		initModelToRender(model);
		return CRM365Constants.VIEW_CUSTOMER_CUSTOMIZATION;
	}



    /**
     * Methode permettant de mettre a jour les champs freeValX d'un client
     * selon la valeur rentree dans le formulaire de detail des clients
     * @return vue VIEW_CUSTOMER_SEARCH
     */
	@RequestMapping(value = "/updateFreeValCustomerRow", method = RequestMethod.POST)
	public String updateFreeValCustomerRow(HttpServletRequest httpServletRequest, ModelMap model,
			@RequestParam(value = "idCustomer", required = true) String idCustomer ,
			@RequestParam(value = "freeValValue[]", required = true) String[] freeValValue,
			@RequestParam(value = "freeValName[]", required = true) String[] freeValName
			) {
		List<String> listFreeValValue = Arrays.asList(freeValValue);
		List<String> listFreeValName = Arrays.asList(freeValName);
		Customer customer;

		customer = customerService.getCustomerById(new Long(idCustomer));

		for (int i=0; i < listFreeValName.size(); i++) {
			customer = customerService.saveCustomerWithSpecificCustomerAlias(customer, listFreeValName.get(i), listFreeValValue.get(i));
		}

		model.put("customer", customer);
		loadCustomerAlias(model, customer);

		return CRM365Constants.VIEW_CUSTOMER_DETAIL;
	}







}