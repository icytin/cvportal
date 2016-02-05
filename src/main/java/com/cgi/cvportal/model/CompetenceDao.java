package com.cgi.cvportal.model;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface CompetenceDao extends CrudRepository<Competence, Long> {

}