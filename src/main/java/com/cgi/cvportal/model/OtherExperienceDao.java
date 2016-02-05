package com.cgi.cvportal.model;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface OtherExperienceDao extends CrudRepository<OtherExperience, Long> {

}