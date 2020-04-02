package q.rorbin.verticaltablayout;


import android.view.View;

/**
 * @author chqiu
 *         Email:qstumn@163.com
 */
public interface TabAdapter {
    int getCount();
    View getTabItemView(int position);
}
