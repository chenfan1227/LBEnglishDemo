package com.make.char_im.chenfan.greenDao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.make.char_im.chenfan.greenDao.DisplayMess;
import com.make.char_im.chenfan.greenDao.MyPhrase;

import com.make.char_im.chenfan.greenDao.DisplayMessDao;
import com.make.char_im.chenfan.greenDao.MyPhraseDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {


    private final DaoConfig displayMessDaoConfig;
    private final DaoConfig myPhraseDaoConfig;

    private final DisplayMessDao displayMessDao;
    private final MyPhraseDao myPhraseDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        displayMessDaoConfig = daoConfigMap.get(DisplayMessDao.class).clone();
        displayMessDaoConfig.initIdentityScope(type);

        myPhraseDaoConfig = daoConfigMap.get(MyPhraseDao.class).clone();
        myPhraseDaoConfig.initIdentityScope(type);

        displayMessDao = new DisplayMessDao(displayMessDaoConfig, this);
        myPhraseDao = new MyPhraseDao(myPhraseDaoConfig, this);

        registerDao(DisplayMess.class, displayMessDao);
        registerDao(MyPhrase.class, myPhraseDao);
    }
    
    public void clear() {
        displayMessDaoConfig.clearIdentityScope();
        myPhraseDaoConfig.clearIdentityScope();
    }

    public DisplayMessDao getDisplayMessDao() {
        return displayMessDao;
    }

    public MyPhraseDao getMyPhraseDao() {
        return myPhraseDao;
    }

}
