package shopcart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ShopCart {
	private List<Product> proLists;
	private Map<String, Product> proMap;
	private int totalPrice;
	private int totalQuantity;

	public List<Product> getProLists() {
		return proLists;
	}

	public void setProLists(List<Product> proLists) {
		this.proLists = proLists;
	}

	public Map<String, Product> getProMap() {
		return proMap;
	}

	public void setProMap(Map<String, Product> proMap) {
		this.proMap = proMap;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	@Override
	public String toString() {
		return "ShopCart [proLists=" + proLists + ", totalPrice=" + totalPrice + ", totalQuantity=" + totalQuantity
				+ "]";
	}

	public ShopCart() {
		proLists = new ArrayList<Product>();
		proMap = new HashMap<String, Product>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(proLists, proMap, totalPrice, totalQuantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopCart other = (ShopCart) obj;
		return Objects.equals(proLists, other.proLists) && Objects.equals(proMap, other.proMap)
				&& totalPrice == other.totalPrice && totalQuantity == other.totalQuantity;
	}

	public void add(Product p) {
		// �O�_���ۦP���ӫ~
		if (!proMap.containsKey(p.getName())) {
//			proLists.add(p);
//			// �ʪ����@���X���ӫ~
//			totalQuantity += p.getQuantity();
//			// �ʪ����`����
//			totalPrice += p.getPrice() * p.getQuantity();

			proMap.put(p.getName(), p);
			// �ʪ����@���X���ӫ~
			totalQuantity += p.getQuantity();
			// �ʪ����`����
			totalPrice += p.getPrice() * p.getQuantity();
		} else {
			int before = proMap.get(p.getName()).getQuantity();
			int after = before + p.getQuantity();
			proMap.get(p.getName()).setQuantity(after);
			totalQuantity += p.getQuantity();
			totalPrice += p.getPrice() * p.getQuantity();
		}
	}

	public int getAllQuantity() {
		int result = 0;
//		Set<String> keys = proMap.keySet();
//		Iterator<String> it = keys.iterator();
//		while (it.hasNext()) {
//			String key = it.next();
//			result += proMap.get(key).getQuantity();
//			return result;
//		}
		return result;
	}
//
	public int getAllPrice() {
		int result = 0;
//		Set<String> keys = proMap.keySet();
//		Iterator<String> it = keys.iterator();
//		while (it.hasNext()) {
//			String key = it.next();
//			result += proMap.get(key).getPrice() * proMap.get(key).getQuantity();
//			return result;
//		}
		return result;
	}

	public void remove() {
//		Set<String> set = proMap.keySet();
//		Iterator<String> it = set.iterator();
//		while (it.hasNext()) {
//			String key = it.next();
//			it.remove();
//		}
//		totalPrice = 0;
//		totalQuantity = 0;
	}

	public static void main(String[] args) {
		ShopCart sc = new ShopCart();
		sc.add(new Product("macbook pro", 2, 36900));
		sc.add(new Product("macbook air", 1, 26900));
		sc.add(new Product("macbook pro", 1, 36900));
		sc.add(new Product("macbook air", 10, 26900));
		Set<String> set = sc.getProMap().keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(sc.getProMap().get(key));
		}
		System.out.println("�ӫ~�`�@: " + sc.getTotalQuantity() + "��");
		System.out.println("�`����$ " + sc.getTotalPrice());
		sc.remove();
		System.out.println("=======�����ʪ�������=======");
		System.out.println(sc.getProMap().get("macbook pro"));
		System.out.println("�ʪ����ŪŪ�");

		// ���X�ʪ����̭������ӫ~
//		for (Product p : sc.getProLists()) {
//			System.out.println(p);
//		}
	}
}
