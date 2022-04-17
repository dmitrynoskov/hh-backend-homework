package ru.hh.school.resource;

import ru.hh.school.dto.vacancy.VacancyAddRequestDto;
import ru.hh.school.service.FavouriteVacancyService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
@Path("/favourites/vacancy")
public class FavouriteVacancyController {

  private final FavouriteVacancyService favouriteVacancyService;

  @Inject
  public FavouriteVacancyController(FavouriteVacancyService favouriteVacancyService) {
    this.favouriteVacancyService = favouriteVacancyService;
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response postVacancy(VacancyAddRequestDto body) {
    if (favouriteVacancyService.addVacancy(body.getId(), body.getComment())) {
      return Response.ok().build();
    } else {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getVacancies(@DefaultValue("0") @DecimalMin("0") @QueryParam("page") Integer page,
                               @DefaultValue("20") @DecimalMin("0") @QueryParam("per_page") Integer perPage) {
    return Response.ok()
      .entity(favouriteVacancyService.getVacancies(page, perPage))
      .build();
  }

  @DELETE
  @Path("/{vacancy_id}")
  public Response deleteVacancy(@NotNull @PathParam("vacancy_id") Long id) {
    if (favouriteVacancyService.delete(id)) {
      return Response.ok().build();
    } else {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }

  @POST
  @Path("/{vacancy_id}/refresh")
  public Response refreshEmployer(@NotNull @PathParam("vacancy_id") Long id) {
    if (favouriteVacancyService.refresh(id)) {
      return Response.ok().build();
    } else {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
  }

}
