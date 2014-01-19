/**
 * source https://github.com/langwan/findtag
 * document http://www.chengxufan.com/article?id=10
 */

package org.cxf.findtag;

import java.util.Iterator;
import java.util.List;

import org.cxf.findtag.lib.Dictionary;
import org.cxf.findtag.lib.Tag;

public class Main {
	public static void main(String[] args) {
		String[] tags = { "程序范儿", "contact", "contact@chengxufan.com", "chengxufan.com", "程序", "移动" };
		Dictionary dict = new Dictionary();
		dict.init();
		for (int i = 0; i < tags.length; i++) {
			dict.insert(tags[i]);
		}
		
		System.out.println("字典结构：");
		
		dict.trace();
		
		System.out.println("");
		System.out.println("");
		
		String content = "程序范儿(chengxufan.com)大约每周一篇稿子，主要讲解编程思想和方法，与其它技术媒体相比，展现的内容更微观，我的目标不是让自己的程序变的更强壮，而是追求更优雅，投稿请联系<contact@chengxufan.com>。";
		List<String> find = dict.search(content);
		List<Tag> findTags = dict.merge(find);
		
		System.out.println("关键字词频：");
		Iterator<Tag> it = findTags.iterator();
		while (it.hasNext()) {
			Tag tag = it.next();
			System.out.println("tag name is " + tag.name + " find " + tag.finds + " times.");
		}
	}
}
