package ru.hh.school.mapper;

import ru.hh.school.dto.employer.EmployerResponse;
import ru.hh.school.dto.employer.EmployerShortResponse;
import ru.hh.school.dto.employer.HhEmployerResponse;
import ru.hh.school.dto.employer.HhShortEmployerResponse;

//import java.text.SimpleDateFormat;

public class EmployerMapper {

  //private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-ddThh:mm:ssZ");

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

  /*public static FavouriteEmployer toEmployerEntity(EmployerResponse employerResponse) {
    Area area = toAreaEntity(employerResponse.getArea());
    FavouriteEmployer favouriteEmployer = new FavouriteEmployer();
    favouriteEmployer.setId(employerResponse.getId());
    favouriteEmployer.setName(employerResponse.getName());
    favouriteEmployer.setDescription(employerResponse.getDescription());
    favouriteEmployer.setArea(area);
    favouriteEmployer.setCreationDate(simpleDateFormat.format(OffsetDateTime.now()));
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

  private static AreaDto toAreaDto(Area area) {
    return new AreaDto(area.getId(), area.getName());
  }
  private static Area toAreaEntity(AreaDto areaDto) {
    return new Area(areaDto.getId(), areaDto.getName());
  }*/

}
