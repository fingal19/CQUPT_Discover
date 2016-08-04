package inter;

import android.view.View;

/**
 * Created by pcx on 2016/8/6.
 */

public interface IOnItemClickListener {
    void onItemClick(View view, int position);
    void onItemLongClick(View view,int position);
}
