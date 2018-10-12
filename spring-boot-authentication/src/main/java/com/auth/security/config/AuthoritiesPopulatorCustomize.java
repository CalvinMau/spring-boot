package com.auth.security.config;

import com.auth.security.bean.PersonnelBean;
import com.auth.security.bean.RoleStatusBean;
import com.auth.security.dao.PersonnelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The type Authorities populator customize.
 *
 * @ClassName AuthoritiesPopulatorCustomize
 * @Description TODO
 * @Author Calvin
 * @Date 10 /12/18
 * @Version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AuthoritiesPopulatorCustomize implements LdapAuthoritiesPopulator{

    @Autowired
    private PersonnelDao personnelDao;

    @Value("${spring.ldap.default.role}")
    private String defaultRoles;


    @Override
    public Collection<GrantedAuthority> getGrantedAuthorities(
            DirContextOperations userData, String username) {

        Attributes attributes = userData.getAttributes();
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        PersonnelBean oneByUname = personnelDao.findOneByUsername(username);
        if(oneByUname == null){
            PersonnelBean personnelBean = new PersonnelBean();
            personnelBean.setUsername(username);
            try {
                if (attributes.get("displayName") != null) {
                    personnelBean.setDisplayName(attributes.get("displayName").get().toString());
                }

                if (attributes.get("title") != null) {
                    personnelBean.setTitle(attributes.get("displayName").get().toString());
                }

                if (attributes.get("mail") != null) {
                    personnelBean.setMail(attributes.get("mail").get().toString());
                }

                if (attributes.get("manager") != null) {
                    personnelBean.setManager(attributes.get("manager").get().toString());
                }
            } catch (NamingException e) {
                e.printStackTrace();
            }

            RoleStatusBean roleStatusBean = new RoleStatusBean();
            roleStatusBean.setRname(defaultRoles);
            personnelBean.addRole(roleStatusBean);
            initUserDO(personnelBean);

            authorities.add(new SimpleGrantedAuthority(defaultRoles));
            return authorities;

        }else {
            for (RoleStatusBean role : oneByUname.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getRname()));
            }
            return authorities;
        }
    }

    private void initUserDO(PersonnelBean personnelBean){
        personnelDao.save(personnelBean);
    }

}
