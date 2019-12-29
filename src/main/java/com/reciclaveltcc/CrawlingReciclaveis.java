package com.reciclaveltcc;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

public class CrawlingReciclaveis {
	
	private static String URL_COOPERATIVAS = "http://cempre.org.br/servico/pesquisa/lista/v4/C/v1/";
	private static String URL_SUCATEIROS = "http://cempre.org.br/servico/pesquisa/lista/v4/S/v1/";
	private static String URL_RECICLADORES = "http://cempre.org.br/servico/pesquisa/lista/v4/R/v1/";
	private static Integer numero_de_estados = 27;

	public static void main(String[] args) throws NotFound {
		crawlingSiteReciclaveis();
	}

	public static void crawlingSiteReciclaveis() throws NotFound {
		UserAgent userAgent = new UserAgent();
		try {
			userAgent.visit("http://cempre.org.br/servico/pesquisa/lista/v4/C/v1/2");
			System.out.println(userAgent.doc.innerHTML());
			String teste = userAgent.doc.findEach("<h3 class=\"tit-sub\">").outerHTML();
			System.out.println(teste.substring(teste.indexOf("4"), teste.lastIndexOf("empresas com as chaves de busca informadas.</h3></#elements>")));
			

			for (int i = 0; i <= 3; i++) {
				String element = userAgent.doc.findEach("<div class=\"bt\">").getElement(i).getParent().outerHTML();
				String url = element.substring(9, element.lastIndexOf("\"><div class"));
				System.out.println(url);
			}

		} catch (ResponseException e) {
			e.printStackTrace();
		}

	}

}
