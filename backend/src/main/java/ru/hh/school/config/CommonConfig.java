package ru.hh.school.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.nab.hibernate.MappingConfig;
import ru.hh.nab.starter.NabCommonConfig;
import ru.hh.school.PostgreSQLEnumType;
import ru.hh.school.client.HhApiClient;
import ru.hh.school.dao.AreaDao;
import ru.hh.school.dao.FavouriteEmployerDao;
import ru.hh.school.dao.GenericDao;
import ru.hh.school.resource.EmployerController;
import ru.hh.school.resource.ExampleResource;
import ru.hh.school.resource.FavouriteEmployerController;
import ru.hh.school.resource.VacancyController;
import ru.hh.school.service.EmployerService;
import ru.hh.school.service.FavouriteEmployerService;
import ru.hh.school.service.VacancyService;
import ru.hh.school.util.TransactionHelper;

@Configuration
@Import({
  // import your beans here
  ExampleResource.class,
  NabCommonConfig.class,
  EmployerController.class,
  HhApiClient.class,
  EmployerService.class,
  FavouriteEmployerController.class,
  FavouriteEmployerService.class,
  VacancyController.class,
  VacancyService.class,
  AreaDao.class,
  FavouriteEmployerDao.class,
  GenericDao.class,
  TransactionHelper.class,
  PostgreSQLEnumType.class
})
public class CommonConfig {

  @Bean
  public MappingConfig mappingConfig() {
    MappingConfig mappingConfig = new MappingConfig();
    mappingConfig.addPackagesToScan("ru.hh.school.entity");
    return mappingConfig;
  }
}
