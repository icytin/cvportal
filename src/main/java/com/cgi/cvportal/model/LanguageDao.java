package com.cgi.cvportal.model;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface LanguageDao extends CrudRepository<Language, Long> {

  /**
   * Requires no implementation. Spring Data JPA will do it.
   *
   * @param code the language code.
   * @return the language having the passed code or null if no language is found.
   */
  public Language findByCode(String code);

} // class UserDao