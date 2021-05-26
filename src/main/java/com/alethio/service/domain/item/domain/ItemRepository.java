package com.alethio.service.domain.item.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ItemRepository<T, ID>  extends JpaRepository<T, ID> {

}
