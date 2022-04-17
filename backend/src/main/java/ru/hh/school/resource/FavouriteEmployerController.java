package ru.hh.school.resource;

import ru.hh.school.dto.employer.EmployerAddRequestDto;
import ru.hh.school.service.FavouriteEmployerService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
@Path("/favourites/employer")
public class FavouriteEmployerController {

  private final FavouriteEmployerService favouriteEmployerService;

  @Inject
  public FavouriteEmployerController(FavouriteEmployerService favouriteEmployerService) {
    this.favouriteEmployerService = favouriteEmployerService;
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response postEmployer(EmployerAddRequestDto body) {
    if (favouriteEmployerService.addEmployer(body.getId(), body.getComment())) {
      return Response.ok().build();
    } else {
      return Response.status(Response.Status.BAD_REQUEST)
        .entity(String.format("Favourite employer with id = %s already exists!", body.getId()))
        .build();
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getEmployers(@DefaultValue("0") @DecimalMin("0") @QueryParam("page") Integer page,
                               @DefaultValue("20") @DecimalMin("0") @QueryParam("per_page") Integer perPage) {
    return Response.ok()
      .entity(favouriteEmployerService.getEmployers(page, perPage))
      .build();
  }

  @PUT
  @Consumes(MediaType.TEXT_PLAIN)
  @Path("/{employer_id}")
  public Response putEmployer(@NotNull @PathParam("employer_id") Long id, String comment) {
    if (favouriteEmployerService.updateComment(id, comment)) {
      return Response.ok().build();
    } else {
      return Response.status(Response.Status.BAD_REQUEST)
        .entity(String.format("Favourite employer with id = %s does not exist!", id))
        .build();
    }
  }

  @DELETE
  @Path("/{employer_id}")
  public Response deleteEmployer(@NotNull @PathParam("employer_id") Long id) {
    if (favouriteEmployerService.delete(id)) {
      return Response.ok().build();
    } else {
      return Response.status(Response.Status.BAD_REQUEST)
        .entity(String.format("Favourite employer with id = %s does not exist!", id))
        .build();
    }
  }

  @POST
  @Path("/{employer_id}/refresh")
  public Response refreshEmployer(@NotNull @PathParam("employer_id") Long id) {
    if (favouriteEmployerService.refresh(id)) {
      return Response.ok().build();
    } else {
      return Response.status(Response.Status.BAD_REQUEST)
        .entity(String.format("Favourite employer with id = %s does not exist!", id))
        .build();
    }
  }

}
