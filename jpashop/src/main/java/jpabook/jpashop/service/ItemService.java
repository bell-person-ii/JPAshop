package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    // 단일 저장
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    // 다중 조회
    @Transactional(readOnly = true)
    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Item findOne(Long id){
        return itemRepository.findOne(id);
    }
}
