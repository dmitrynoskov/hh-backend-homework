package ru.hh.school.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.nab.hibernate.MappingConfig;
import ru.hh.nab.starter.NabCommonConfig;
import ru.hh.school.client.HhApiClient;
import ru.hh.school.dao.AreaDao;
import ru.hh.school.dao.FavouriteEmployerDao;
import ru.hh.school.dao.FavouriteVacancyDao;
import ru.hh.school.resource.*;
import ru.hh.school.service.EmployerService;
import ru.hh.school.service.FavouriteEmployerService;
import ru.hh.school.service.FavouriteVacancyService;
import ru.hh.school.service.VacancyService;
import ru.hh.school.util.TransactionHelper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@Configuration
@Import({
  // import your beans here
  ExampleResource.class,
  NabCommonConfig.class,
  EmployerController.class,
  FavouriteEmployerController.class,
  VacancyController.class,
  FavouriteVacancyController.class,
  EmployerService.class,
  FavouriteEmployerService.class,
  VacancyService.class,
  FavouriteVacancyService.class,
  HhApiClient.class,
  AreaDao.class,
  FavouriteEmployerDao.class,
  FavouriteVacancyDao.class,
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

  @Bean
  public Client client() {
    return ClientBuilder.newClient();
  }

}
