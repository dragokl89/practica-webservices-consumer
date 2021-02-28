/**
 * 
 */
package com.devpredator.practicawebservicesconsumer.client;

import java.time.LocalDateTime;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.devpredator.practicawebservicesconsumer.dto.RestauranteDTO;

/**
 * @author 4PF28LA_2004
 *
 */
public class RestaurantesWSClient {
	public static void main(String[] args) {
		 
//		Client client = ClientBuilder.newClient();
//		WebTarget webTarget = client.target("http://localhost:8080/practica-webservices/devpredator/restaurantesWS").path("consultarRestaurantes");
//		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
//		Response response = invocationBuilder.get();
//		
//
//		
//	
//			List<RestauranteDTO> restaurantes =  response.readEntity(new GenericType<List<RestauranteDTO>>() {});
//			
//			for (RestauranteDTO restauranteDTO : restaurantes) {
//				System.out.println(restauranteDTO.getNombre());
//			}
//		
			
		
		
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/practica-webservices/devpredator/restaurantesWS")
				.path("guardarRestaurante");

		RestauranteDTO restaurante = new RestauranteDTO();
		restaurante.setNombre("Encebollados");
		restaurante.setIdRestaurante(789L);
		restaurante.setSlogan("Delicia del mar");
		restaurante.setDireccion("Carcelen");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(restaurante, MediaType.APPLICATION_JSON));

		if (response.getStatus() == 400) {
			String error = response.readEntity(String.class);
			System.out.println(error);
		}

		if (response.getStatus() == 200) {
			RestauranteDTO restauranteDTO = response.readEntity(RestauranteDTO.class);
			System.out.println("Nombre del Restaurante :" + restauranteDTO.getNombre());

		}
	}
}
