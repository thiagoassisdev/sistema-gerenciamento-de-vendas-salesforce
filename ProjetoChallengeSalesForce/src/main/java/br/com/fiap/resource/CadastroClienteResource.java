package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.beans.CadastroCliente;
import br.com.fiap.bo.CadastroClientreBO;

@Path("/cadastroCliente")
public class CadastroClienteResource {
	
	private CadastroClientreBO cadastroClienteBO = new CadastroClientreBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<CadastroCliente> selecionarRs() throws ClassNotFoundException, SQLException {
		return (ArrayList<CadastroCliente>) cadastroClienteBO.selecionarBo(); 
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(CadastroCliente cadastroCliente, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		cadastroClienteBO.inserirBo(cadastroCliente);
		
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(cadastroCliente.getCpf().toString());
		
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{cpf}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizarRs(CadastroCliente cadastroCliente, @PathParam("cpf") String cpf)
			throws ClassNotFoundException, SQLException {
		cadastroClienteBO.atualizarBo(cadastroCliente);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{cpf}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("cpf") String cpf)
	        throws ClassNotFoundException, SQLException {
	    cadastroClienteBO.deletarBo(cpf);
	    return Response.ok().build();
	}
}