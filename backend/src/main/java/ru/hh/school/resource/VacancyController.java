package ru.hh.school.resource;

import ru.hh.school.service.VacancyService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
@Path("/vacancy")
public class VacancyController {

  @Inject
  private VacancyService vacancyService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getVacancies(@DefaultValue("") @QueryParam("query") String text,
                               @DefaultValue("0") @DecimalMin("0") @QueryParam("page") Integer page,
                               @DefaultValue("20") @DecimalMin("0") @QueryParam("per_page") Integer perPage) {
    return Response
      .ok()
      .entity(vacancyService.getVacancies(text, page, perPage))
      .build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{vacancy_id}")
  public Response getVacancyById(@PathParam("vacancy_id") Long vacancyId) {
    return Response
      .ok()
      .entity(vacancyService.getVacancyById(vacancyId))
      .build();
  }

}
