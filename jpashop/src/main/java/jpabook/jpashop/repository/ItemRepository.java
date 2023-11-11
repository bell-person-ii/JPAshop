package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    // 아이템 저장
    public void save(Item item){
        // id가 존재하지 않느 경우 : 신규 저장인 경우
        if (item.getId() == null){
            em.persist(item);
        }
        // id가 존재하는 경우 : 기존에 저장된 데이터가 있는 경우
        else{
            em.merge(item);
        }
    }

    // id를 통한 아이템 단일 조회
    public Item find(Long id){
        return em.find(Item.class,id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }
}
