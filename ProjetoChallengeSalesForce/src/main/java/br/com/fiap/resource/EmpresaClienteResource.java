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

import br.com.fiap.beans.EmpresaCliente;
import br.com.fiap.bo.EmpresaClienteBO;

@Path("/empresaCliente")
public class EmpresaClienteResource {

	private EmpresaClienteBO empresaClienteBO = new EmpresaClienteBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<EmpresaCliente> selecionarRs() throws ClassNotFoundException, SQLException {

		return (ArrayList<EmpresaCliente>) empresaClienteBO.selecionarBo();
	}

	@POST
	@Consumes
	public Response inserirRs(EmpresaCliente empresaCliente, @Context UriInfo uriInfo)
			throws ClassNotFoundException, SQLException {
		empresaClienteBO.inserirBo(empresaCliente);

		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(empresaCliente.getNome().toString());

		return Response.created(builder.build()).build();

	}

	@PUT
	@Path("/{nome}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizarRs(EmpresaCliente empresaCliente, @PathParam("nome") String nome)
			throws ClassNotFoundException, SQLException {
		empresaClienteBO.atualizarBo(empresaCliente);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{nome}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletarRs(EmpresaCliente empresaCliente, @PathParam("nome") String nome)
	        throws ClassNotFoundException, SQLException {
	    empresaClienteBO.deletarBo(nome);
	    return Response.ok().build();
	}
}
