package br.com.framework.implementacao.crud;

import br.com.framework.hibernate.session.HibernateUtil;
import br.com.framework.interfaces.crud.InterfaceCrud;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Component
@Transactional
public class ImplementacaoCrud<T> implements InterfaceCrud<T>, Serializable {

    private static final long serialVersionUID = 1L;

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SimpleJdbcTemplateImpl simpleJdbcTemplate;

    @Autowired
    private SimpleJdbcInsertImplements simpleJdbcInsertImplements;

    @Autowired
    private SimpleJdbcTemplateImpl simpleJdbcTemplateImpl;

    private SimpleJdbcTemplate getSimpleJdbcTemplateImpl(){
        return simpleJdbcTemplateImpl;
    }

    public void save(Object obj) throws Exception {

    }

    public void persist(Object obj) throws Exception {

    }

    public void saveOrUpdate(Object obj) throws Exception {

    }

    public void update(Object obj) throws Exception {

    }

    public void delete(Object obj) throws Exception {

    }

    public Object merge(Object obj) throws Exception {
        return null;
    }

    public List findList(Class objs) throws Exception {
        return null;
    }

    public Object findById(Class entidade, Long id) throws Exception {
        return null;
    }

    public Object findByPorId(Class entidade, Long id) throws Exception {
        return null;
    }

    public List findListByQueryDinamica(String s) throws Exception {
        return null;
    }

    public void executeUpdateQueryDinamica(String s) throws Exception {

    }

    public void executeUpdateSQLDinamica(String s) throws Exception {

    }

    public void clearSession() throws Exception {

    }

    public void evict(Object objs) throws Exception {

    }

    public Session getSession() throws Exception {
        return null;
    }

    public List<?> getListSQLDinamica(String sql) throws Exception {
        return null;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public SimpleJdbcTemplate getSimpleJdbcTemplate() {
        return simpleJdbcTemplate;
    }

    public SimpleJdbcInsert getSimpleJdbcInsert() {
        return simpleJdbcInsertImplements;
    }

    public Long totalRegistro(String table) throws Exception {
        return null;
    }

    public Query obterQuery(String query) throws Exception {
        return null;
    }

    public List findListByQueryDinamica(String query, int iniciaNoRegistro, int maximoResultado) throws Exception {
        return null;
    }

    private void validaSessionFactory(){
        if(Objects.isNull(sessionFactory)){
            sessionFactory = HibernateUtil.getSessionFactory();
        }
        validarTransaction();
    }

    private void validarTransaction(){
        if(!sessionFactory.getCurrentSession().getTransaction().isActive()){
            sessionFactory.getCurrentSession().beginTransaction();
        }
    }

    private void commitProcessoAjax(){
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }

    private void rollBackProcessoAjax(){
        sessionFactory.getCurrentSession().beginTransaction().rollback();
    }
}
