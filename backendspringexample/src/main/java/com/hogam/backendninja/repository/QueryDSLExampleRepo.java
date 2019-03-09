package com.hogam.backendninja.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.hogam.backendninja.entity.Course;
import com.hogam.backendninja.entity.QCourse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

	private QCourse qCourse = QCourse.course;

	@PersistenceContext
	private EntityManager em;

	public Course find(boolean exist) {
		JPAQuery<Course> query = new JPAQuery<>(em);

		qCourse.description.endsWith("OP");

		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));

		if (exist) {
			Predicate predicate2 = qCourse.id.eq(23);
			predicateBuilder.and(predicate2);
		} else {
			Predicate predicate3 = qCourse.name.endsWith("OP");
			predicateBuilder.or(predicate3);

		}
//		Course course1 = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
//
//		List<Course> courses = query.select(qCourse).from(qCourse).where(predicateBuilder).fetch();

		return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();

	}
}
