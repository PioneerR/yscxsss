package temp;

import com.yscxsss.service.product.ProductService;
import com.yscxsss.service.product.ProductServiceImpl;


public class ProductServiceFactory {

	private ProductServiceFactory() {
	}
	private static ProductService ps=null;
	public static ProductService getInstance() {
		if(ps==null){
			ps=new ProductServiceImpl();					
		}
		return ps;
	}
}
