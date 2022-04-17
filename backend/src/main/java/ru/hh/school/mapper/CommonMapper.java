package ru.hh.school.mapper;

import ru.hh.school.dto.AreaDto;
import ru.hh.school.entity.Area;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.Date;

public class CommonMapper {

  private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");

  protected static String getFormattedTime() {
    return simpleDateFormat.format(Date.from(OffsetDateTime.now().toInstant()));
  }

  protected static AreaDto toAreaDto(Area area) {
    return new AreaDto(area.getId(), area.getName());
  }
  protected static Area toAreaEntity(AreaDto areaDto) {
    return new Area(areaDto.getId(), areaDto.getName());
  }

}
