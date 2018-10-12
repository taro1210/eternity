package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.ProductListLogic;
import model.ShoppingCart;

@WebServlet("/Cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartServlet() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの文字コードをUTF-8に設定
		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータactionの取得
		String action = request.getParameter("action");
		// デフォルトのフォワード先を格納する文字列
		String path = "/WEB-INF/jsp/list.jsp";

		// セッションスコープの取得（既存のセッションスコープがない場合は、新規作成）
		HttpSession session = request.getSession(true);

		// セッションスコープに格納するインスタンス変数を宣言
		Map<String, ShoppingCart> cart = null;
		List<Product> lists = null;

		// 処理インスタンンスを生成
		ProductListLogic listLogic = new ProductListLogic();

		// actionの判定
		if (action == null) {
			// 2回目以降のアクセスなので、セッションスコープからインスタンスを取得
			lists = (ArrayList<Product>) session.getAttribute("lists");
			cart = (HashMap<String, ShoppingCart>) session.getAttribute("cart");

			if (lists == null) {
				// 起動時もしくは、セッション削除後となるため、処理ロジックから商品全件を取得
				lists = listLogic.getProductList();
				// セッションスコープにセット
				session.setAttribute("lists", lists);
			}
			// ショッピングカートを空にしている場合
			if (cart == null) {
				// ショッピングカートを新規作成
				cart = new HashMap<String, ShoppingCart>();
				// セッションスコープにセット
				session.setAttribute("cart", cart);
			}
		} else
			switch (action) {
			case "logout": // ログアウトリンクをクリックしたとき
				// セッションを破棄
				session.invalidate();
				// 遷移先をlogout.jspに設定
				path = "/WEB-INF/jsp/logout.jsp";
				break;
			case "add": // カートに追加ボタンをクリックしたとき
				// リクエストパラメータから商品IDを取得
				String productId = request.getParameter("product_id");
				// リクエストパラメータで渡された商品IDの商品情報を取得
				Product product = listLogic.getProduct(productId);

				// セッションスコープからカート情報を取得
				cart = (HashMap<String, ShoppingCart>) session.getAttribute("cart");

				if (product != null) {
					// ショッピングカート情報を取得
					ShoppingCart shoppingCart = (ShoppingCart) cart.get(product.getId());
					if (shoppingCart != null) {
						// 同じ商品だったので+1した値で再セット
						shoppingCart.setCount(shoppingCart.getCount() + 1);
					} else {
						// 新しい商品であるため、新規作成し、cartに登録
						shoppingCart = new ShoppingCart();
						shoppingCart.setProduct(product);
						shoppingCart.setCount(1);
						cart.put(productId, shoppingCart);
					}
				}
				// 遷移先をカート内一覧に設定
				path = "/WEB-INF/jsp/cart.jsp";
				break;
			case "delete":
				// セッション内のカートを空にする
				session.removeAttribute("cart");
				// 遷移先をカート内一覧に設定
				path = "/WEB-INF/jsp/cart.jsp";
				break;
			}

		// フォワード（actionに対応した遷移先で）
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// postの場合でもdoGetメソッドを実行するように
		doGet(request, response);
	}
}