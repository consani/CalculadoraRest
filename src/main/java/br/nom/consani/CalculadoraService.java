package br.nom.consani;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/calc")
public class CalculadoraService {

	
	@GET
	@Path("/")
	public Response info() {
		String out = "Sufixo da URL: [op]/numero1/numero2 "
				+ "<br> numero1: double value "
				+ "<br> numero2: double value "
				+ "<br> op = soma | subtracao | multiplicacao | divisao ";
		
		return Response.status(200).entity(out).build();
	}
	
	@GET
	@Path("/soma/{num1}/{num2}")
	public Response soma(@PathParam("num1") String sNum1, @PathParam("num2") String sNum2) {
		try {
			double numero1 = Double.parseDouble(sNum1.replace(",", "."));
			double numero2 = Double.parseDouble(sNum2.replace(",", "."));
			double out = (numero1 + numero2);
			System.out.println(String.format("%.2f + %.2f = %.2f", numero1, numero2, out));
			return Response.status(200).entity(out).build();
		} catch (NumberFormatException e) {
			throw new BadRequestException(e.getMessage());
		}
	}

	@GET
	@Path("/subtracao/{num1}/{num2}")
	public Response subtracao(@PathParam("num1") String sNum1, @PathParam("num2") String sNum2) {
		try {
			double numero1 = Double.parseDouble(sNum1.replace(",", "."));
			double numero2 = Double.parseDouble(sNum2.replace(",", "."));
			double out = (numero1 - numero2);
			System.out.println(String.format("%.2f - %.2f = %.2f", numero1, numero2, out));
			return Response.status(200).entity(out).build();
		} catch (NumberFormatException e) {
			throw new BadRequestException(e.getMessage());
		}
	}

	@GET
	@Path("/multiplicacao/{num1}/{num2}")
	public Response multiplicacao(@PathParam("num1") String sNum1, @PathParam("num2") String sNum2) {
		try {
			double numero1 = Double.parseDouble(sNum1.replace(",", "."));
			double numero2 = Double.parseDouble(sNum2.replace(",", "."));
			double out = (numero1 * numero2);
			System.out.println(String.format("%.2f x %.2f = %.2f", numero1, numero2, out));
			return Response.status(200).entity(out).build();
		} catch (NumberFormatException e) {
			throw new BadRequestException(e.getMessage());
		}
	}

	@GET
	@Path("/divisao/{num1}/{num2}")
	public Response divisao(@PathParam("num1") String sNum1, @PathParam("num2") String sNum2) {
		try {
			double numero1 = Double.parseDouble(sNum1.replace(",", "."));
			double numero2 = Double.parseDouble(sNum2.replace(",", "."));
			double out = (numero1 / numero2);
			System.out.println(String.format("%.2f div %.2f = %.2f", numero1, numero2, out));
			return Response.status(200).entity(out).build();
		} catch (NumberFormatException e) {
			throw new BadRequestException(e.getMessage());
		}
	}

}
