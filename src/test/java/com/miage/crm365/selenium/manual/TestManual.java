package com.miage.crm365.selenium.manual;

/**
 * Cette classe de tests est une classe "abstraite" permettant d'indiquer les procedures et
 * demarches pour realiser des tests manuellement.
 * Le but de cette classe, étant donné que certains tests necessitent des ressources personnelles
 * se trouvant sur la machine de l'utilisateur en question (comme par exemple les tests d'upload de fichier csv
 * qui impliquent necessairement d'avoir le fichier csv sur le poste sur lequel se deroule le test), est de laisser
 * l'utilisateur faire les tests manuellement pour valider les fonctions fournies
 * @author eric RAKOTOBE
 */
public class TestManual {




	/**
	 * Test pour l'insertion en bdd
	 * d'events, eventparameter et eventparametervalue
	 * via un fichier csv,
	 */
	public void testEventUploadCsvOkForRightCsv() {
		/**Copiez collez le fichier F = \{classpath}\CsvFiles\MobilePurchase.csv sur votre machine **/
		/**Authentifiez vous avec Login = user -- Password = user **/
		/**Cliquez sur le menu File Input dans EventManagement **/

		/**Cliquez sur le bouton permettant de choisir un fichier **/
		/**Choisissez le fichier F comme ressource a uploader**/
		/**Cliquez sur "ok" pour valider **/

		/**Assert que vous avez ete rediriger vers uploadEventsFromCsv.event **/
		/**Assert que dans la page, il est indique le nombre de lignes inserees
		   ex:"7 (events/eventparametervalue) lines was inserted in database" **/
	}






	/**
	 * Test pour l'insertion en bdd
	 * d'events, eventparameter et eventparametervalue
	 * via un fichier csv,
	 */
	public void testEventUploadCsvKoForWrongCsv() {
		/**Authentifiez vous avec Login = user -- Password = user **/
		/**Cliquez sur le menu File Input dans EventManagement **/

		/**Cliquez sur le bouton permettant de choisir un fichier **/
		/**Choisissez n'importe quel fichier comme ressource a uploader**/
		/**Cliquez sur "ok" pour valider **/

		/**Assert que vous avez ete rediriger vers uploadEventsFromCsv.event **/
		/**Assert que dans la page, un message d'erreur est present en rouge
		   ex : File name or header is not the one expected for events import, please try with another file **/
	}
	
	
	
	/**
	 * Test pour l'insertion en bdd des clients 
	 * via un fichier csv,
	 */
	public void testCustomerUploadCsvOkForRightCsv() {
		/**Copiez collez le fichier F = \{classpath}\CsvFiles\Customer.csv sur votre machine **/
		/**Authentifiez vous avec Login = user -- Password = user **/
		/**Cliquez sur le menu Customer File Input dans Customer **/

		/**Cliquez sur le bouton permettant de choisir un fichier **/
		/**Choisissez le fichier F comme ressource a uploader**/
		/**Cliquez sur "ok" pour valider **/

		/**Assert que vous avez ete rediriger vers uploadCustomerFromCsv.customer **/
		/**Assert que dans la page, il est indique le nombre de lignes inserees
		   ex:"5 customers was inserted in database" **/
	}






	/**
	 * Test pour l'insertion en bdd des clients
	 * via un fichier csv,
	 */
	public void testCustomerUploadCsvKoForWrongCsv() {
		/**Authentifiez vous avec Login = user -- Password = user **/
		/**Cliquez sur le menu Customer File Input dans Customer **/

		/**Cliquez sur le bouton permettant de choisir un fichier **/
		/**Choisissez n'importe quel fichier comme ressource a uploader**/
		/**Cliquez sur "ok" pour valider **/

		/**Assert que vous avez ete rediriger vers uploadCustomerFromCsv.customer **/
		/**Assert que dans la page, un message d'erreur est present en rouge
		   ex : File name or header is not the one expected for customers import, please try with another file **/
	}

}
