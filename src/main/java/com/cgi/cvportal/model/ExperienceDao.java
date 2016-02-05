package com.cgi.cvportal.model;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ExperienceDao extends CrudRepository<Experience, Long> {

}