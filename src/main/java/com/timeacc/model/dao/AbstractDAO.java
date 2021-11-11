package com.timeacc.model.dao;

import java.util.logging.Logger;

public abstract class AbstractDAO {
    private static final Logger logger = Logger.getLogger("com.timeacc.model.dao.AbstractDAO");

    public void close(AutoCloseable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                logger.severe(e.getMessage());
            }
        }
    }
}
