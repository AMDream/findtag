/**
 * source https://github.com/langwan/findtag
 * document http://www.chengxufan.com/article?id=10
 */
package org.cxf.findtag.lib;

public interface IFloor {
	public void insert(int data);

	public void trace();

	public void traceTags();

	public BaseNode search(int data);

	public BaseNode getSelected();
}
