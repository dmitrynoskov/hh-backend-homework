package ru.hh.school.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.hh.nab.common.properties.FileSettings;

@Repository
public class AreaDao extends GenericDao {

  public AreaDao(SessionFactory sessionFactory, FileSettings fileSettings) {
    super(sessionFactory, fileSettings);
  }

}
