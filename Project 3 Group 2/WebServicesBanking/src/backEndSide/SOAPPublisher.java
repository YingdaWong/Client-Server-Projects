package backEndSide;

import javax.xml.ws.Endpoint;

public class SOAPPublisher {

	public static void main(String[] args) {

		Endpoint ep = Endpoint.create(new ExposedBankingWebServiceImpl());
		ep.publish("http://localhost:5001/WebServicesBanking/ExposedBankingWebService");

	}

}

