package com.hogam.backendninja.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hogam.backendninja.entity.Course;
import com.hogam.backendninja.repository.CourseJpaRepository;
import com.hogam.backendninja.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;

	@Override
	public List<Course> listAllCourses() {
		LOG.info("Call: " + "listAllCourses()");
		return courseJpaRepository.findAll();

	}

	@Override
	public Course addCourse(Course course) {
		LOG.info("Call: " + "addCourse(Course course)");

		return courseJpaRepository.save(course);

	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		return courseJpaRepository.save(course);
	}

}
