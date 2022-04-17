package ru.hh.school.mapper;

import ru.hh.school.dto.Popularity;
import ru.hh.school.dto.employer.EmployerResponseDto;
import ru.hh.school.dto.employer.EmployerShortResponseDto;
import ru.hh.school.dto.employer.FavouriteEmployerResponseDto;
import ru.hh.school.dto.employer.HhEmployerResponseDto;
import ru.hh.school.dto.employer.HhShortEmployerResponseDto;
import ru.hh.school.entity.Area;
import ru.hh.school.entity.FavouriteEmployer;

public class EmployerMapper extends CommonMapper {

  public static EmployerShortResponseDto toShortResponse(HhEmployerResponseDto hhEmployerResponseDto) {
    return new EmployerShortResponseDto(hhEmployerResponseDto.getId(), hhEmployerResponseDto.getName());
  }

  public static EmployerShortResponseDto toShortResponse(HhShortEmployerResponseDto hhEmployerResponse) {
    return new EmployerShortResponseDto(hhEmployerResponse.getId(), hhEmployerResponse.getName());
  }

  public static EmployerResponseDto toResponse(HhEmployerResponseDto hhEmployerResponseDto) {
    return new EmployerResponseDto(
      hhEmployerResponseDto.getId(),
      hhEmployerResponseDto.getName(),
      hhEmployerResponseDto.getDescription(),
      hhEmployerResponseDto.getArea()
    );
  }

  public static FavouriteEmployer toEmployerEntity(EmployerResponseDto employerResponseDto, String comment) {
    Area area = toAreaEntity(employerResponseDto.getArea());
    FavouriteEmployer favouriteEmployer = new FavouriteEmployer();
    favouriteEmployer.setId(employerResponseDto.getId());
    favouriteEmployer.setName(employerResponseDto.getName());
    favouriteEmployer.setDescription(employerResponseDto.getDescription());
    favouriteEmployer.setArea(area);
    favouriteEmployer.setCreationDate(getFormattedTime());
    favouriteEmployer.setComment(comment);
    favouriteEmployer.setViewsCount(0);
    favouriteEmployer.setPopularity(Popularity.REGULAR);
    return favouriteEmployer;
  }

  public static FavouriteEmployerResponseDto toFavouriteResponse(FavouriteEmployer favouriteEmployer) {
    return new FavouriteEmployerResponseDto(favouriteEmployer.getId(),
      favouriteEmployer.getName(),
      favouriteEmployer.getCreationDate(),
      favouriteEmployer.getDescription(),
      toAreaDto(favouriteEmployer.getArea()),
      favouriteEmployer.getComment(),
      favouriteEmployer.getPopularity(),
      favouriteEmployer.getViewsCount());
  }

}
