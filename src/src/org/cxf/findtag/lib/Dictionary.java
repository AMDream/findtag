/**
 * source https://github.com/langwan/findtag
 * document http://www.chengxufan.com/article?id=10
 */
package org.cxf.findtag.lib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.cxf.findtag.floor.BTree;

public class Dictionary {

	IFloor mRootFloor = null;
	BaseNode mRootNode = null;

	public void insert(String tag) {
		byte[] bs = tag.getBytes();
		int data;

		BaseNode node = mRootNode;
		for (int i = 0; i < bs.length; i++) {
			data = bs[i];
			if (node.son == null) {
				node.son = newFloor();
			}
			node.son.insert(data);
			node = node.son.getSelected();
		}
		if (node != null)
			node.flag = true;
	}

	public void init() {
		mRootFloor = newFloor();
		mRootFloor.insert(0);
		mRootNode = mRootFloor.getSelected();
	}

	public void trace() {
		mRootFloor.traceTags();
	}

	public IFloor newFloor() {
		return new BTree();
	}

	public List<String> search(String content) {

		byte bs[] = content.getBytes();
		String str;

		List<Integer> tag = new ArrayList<Integer>();
		List<String> tags = new ArrayList<String>();
		int data;
		IFloor floor;
		BaseNode node = null;
		for (int i = 0; i < bs.length; i++) {

			if (node == null || node.son == null) {
				tag.clear();
				node = mRootNode;

				// continue;
			}
			floor = node.son;
			data = bs[i];
			node = floor.search(data);
			if (node != null) {
				tag.add(data);
				if (node.flag == true) {
					str = Utils.iltos(tag);
					tags.add(str);
				}
			}
		}
		return tags;
	}

	static public List<Tag> merge(List<String> tags) {
		List<Tag> ret = new ArrayList<>();
		Iterator<String> it = tags.iterator();
		String str;
		Tag tag;
		Tag find;
		while (it.hasNext()) {
			find = null;
			str = it.next();
			Iterator<Tag> itTag = ret.iterator();
			while (itTag.hasNext()) {
				tag = itTag.next();
				if (tag.name.equals(str)) {
					find = tag;
					break;
				}
			}
			if (find != null) {
				find.finds++;
			} else {
				find = new Tag();
				find.name = str;
				ret.add(find);
			}
		}
		return ret;
	}
}
