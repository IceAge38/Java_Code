package sit.int202.classicmodels.models;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart<K, V extends CartItem>  {
                     // ตัว V เป็น class ลูกหลานของ CartItem จาก interface
    private Map<K, V> map;

    public Cart() {
        this.map = new HashMap<>();
    }

    public int getNoOfItem() {
        return map.size();
    }

    public int getQuantity() {
        return map.values().stream().mapToInt(o -> o.getQuantity()).sum();
    }

    public Collection<V> getAllItem() {
        return Collections.unmodifiableCollection(map.values());
    }

    public double getTotalPrice() {
        //นำข้อมูลมาวนลูป ผ่าน stream แล้ว map จากนั้นนำไป sum กัน
        return map.values().stream().mapToDouble(o -> o.getTotal()).sum();

//-for loop ปกติ
//        double sum = 0;
//        for(V value : map.values()){
//            sum = sum + value.getTotal();
//        }
//        return sum;
    }

    public void addItem(K key, V value) {
        V item = map.get(key);
        if (item == null) {
            map.put(key, value);
        } else {
            item.setQuantity(item.getQuantity() + value.getQuantity());
        }
    }

    public V removeItem(K key) {
        return map.remove(key);
    }

    public void clear() {
        map.clear();
    }

}
