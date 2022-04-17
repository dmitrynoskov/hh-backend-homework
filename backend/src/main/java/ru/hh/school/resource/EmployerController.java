package ru.hh.school.resource;

import ru.hh.school.service.EmployerService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
@Path("/employer")
public class EmployerController {

  @Inject
  private EmployerService employerService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getEmployers(@DefaultValue("") @QueryParam("query") String text,
                               @DefaultValue("0") @DecimalMin("0") @QueryParam("page") Integer page,
                               @DefaultValue("20") @DecimalMin("0") @QueryParam("per_page") Integer perPage) {
    return Response
      .ok()
      .entity(employerService.getEmployers(text, page, perPage))
      .build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{employer_id}")
  public Response getEmployerById(@NotNull @PathParam("employer_id") Long employerId) {
    return Response
      .ok()
      .entity(employerService.getEmployerById(employerId))
      .build();
  }

}
