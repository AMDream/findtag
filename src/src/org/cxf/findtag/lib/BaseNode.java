/**
 * source https://github.com/langwan/findtag
 * document http://www.chengxufan.com/article?id=10
 */
package org.cxf.findtag.lib;

abstract public class BaseNode {

	public IFloor son;
	public boolean flag;
	public int data;

	protected BaseNode() {
		son = null;
		flag = false;
	}

}
