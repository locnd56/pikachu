package gioi.developer.pilacha_hd.components;

/**
 * Tính toàn số cao có được khi hoàn thành level, xác định thời gian chơi của
 * từng level
 * 
 * @author Mr.Incredible
 *
 */
public class Level {
	public static int totalLevel = 15;
	public static int levelCurrent = 1;

	public static int getTimeLevel() {
		// Mỗi 1 cặp ăn được quy đinh cho phép tìm tối đa trong 3s
		// Phải trừ (Level.levelCurrent -1)*4 sau mỗi level time sẽ giảm đi để
		// tạo
		// nên áp lực cho người chơi, giúp người chơi phải nhanh tay hơn
		return (MT.row * MT.column * 3) - (Level.levelCurrent - 1) * 4;
	}

	/**
	 * Tính xem level và time đạt bao nhiêu sao
	 */
	public static int getStarByLevel(int level, int time) {
		int star = 0;
		int timeLevel = getTimeLevel() / 5;
		if (time <= timeLevel * 2) {
			return 3;
		} else if (time <= timeLevel * 3) {
			return 2;
		} else if (time <= timeLevel * 4) {
			return 1;
		}
		return star;
	}
}
