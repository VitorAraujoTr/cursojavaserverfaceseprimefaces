package br.com.framework.implementacao.crud;

import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.Serializable;

@Component
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SimpleJdbcClassImpl extends SimpleJdbcCall implements Serializable {

    private static final long serialVersionUID = 1L;

    public SimpleJdbcClassImpl(DataSource dataSource) {
        super(dataSource);
    }
}
