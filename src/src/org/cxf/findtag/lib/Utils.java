/**
 * source https://github.com/langwan/findtag
 * document http://www.chengxufan.com/article?id=10
 */
package org.cxf.findtag.lib;

import java.util.List;

public class Utils {
	static public String iltos(List<Integer> list) {
		byte[] bs = new byte[list.size()];
		for (int i = 0; i < bs.length; i++) {
			bs[i] = (byte) list.get(i).byteValue();
		}
		String str = new String(bs);
		return str;
	}
}
