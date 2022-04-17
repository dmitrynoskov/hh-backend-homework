package ru.hh.school.mapper;

import ru.hh.school.Popularity;
import ru.hh.school.dto.employer.*;
import ru.hh.school.entity.Area;
import ru.hh.school.entity.FavouriteEmployer;

public class EmployerMapper extends CommonMapper {

  public static EmployerShortResponse toShortResponse(HhEmployerResponse hhEmployerResponse) {
    return new EmployerShortResponse(hhEmployerResponse.getId(), hhEmployerResponse.getName());
  }

  public static EmployerShortResponse toShortResponse(HhShortEmployerResponse hhEmployerResponse) {
    return new EmployerShortResponse(hhEmployerResponse.getId(), hhEmployerResponse.getName());
  }

  public static EmployerResponse toResponse(HhEmployerResponse hhEmployerResponse) {
    return new EmployerResponse(
      hhEmployerResponse.getId(),
      hhEmployerResponse.getName(),
      hhEmployerResponse.getDescription(),
      hhEmployerResponse.getArea()
    );
  }

  public static FavouriteEmployer toEmployerEntity(EmployerResponse employerResponse, String comment) {
    Area area = toAreaEntity(employerResponse.getArea());
    FavouriteEmployer favouriteEmployer = new FavouriteEmployer();
    favouriteEmployer.setId(employerResponse.getId());
    favouriteEmployer.setName(employerResponse.getName());
    favouriteEmployer.setDescription(employerResponse.getDescription());
    favouriteEmployer.setArea(area);
    favouriteEmployer.setCreationDate(getFormattedTime());
    favouriteEmployer.setComment(comment);
    favouriteEmployer.setViewsCount(0);
    favouriteEmployer.setPopularity(Popularity.REGULAR);
    return favouriteEmployer;
  }

  public static FavouriteEmployerResponse toFavouriteResponse(FavouriteEmployer favouriteEmployer) {
    return new FavouriteEmployerResponse(favouriteEmployer.getId(),
      favouriteEmployer.getName(),
      favouriteEmployer.getCreationDate(),
      favouriteEmployer.getDescription(),
      toAreaDto(favouriteEmployer.getArea()),
      favouriteEmployer.getComment(),
      favouriteEmployer.getPopularity(),
      favouriteEmployer.getViewsCount());
  }

}
