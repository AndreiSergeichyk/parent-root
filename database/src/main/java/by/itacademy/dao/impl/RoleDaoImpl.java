package by.itacademy.dao.impl;

import by.itacademy.entity.Role;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Repository
public class RoleDaoImpl extends BaseDao<Integer, Role> {
}
