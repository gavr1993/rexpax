package com.rexpax.ui.components;

import java.util.List;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.rexpax.R;
import com.rexpax.ui.adapter.NavigationMenuAdapter;

public class NavigationDrawerHelper {
	
	private ActionBarDrawerToggle drawerToggle;
	private DrawerLayout drawer;
	private View drawerContent;
	private AppCompatActivity activity;
	private ListView menuList;
    private int currentSelectedPosition = 0;
    private List<ScreenItem> items;
	private NavigationDrawerListener listener;
	private NavigationMenuAdapter adapter;

	public interface NavigationDrawerListener {
		void onNavigationDrawerItemSelected(int position, ScreenItem item);
	}

	public void setOnNavigationDrawerListener(NavigationDrawerListener listener) {
		this.listener = listener;
	}

	public NavigationDrawerHelper() {}
	
	public NavigationDrawerHelper(AppCompatActivity activity) {
		init(activity);
	}
	
	public void init(AppCompatActivity activity) {
		this.activity = activity;
		drawer = (DrawerLayout) activity.findViewById(R.id.drawer);
		drawerContent = activity.findViewById(R.id.drawerContent);
		if (drawerContent != null) {
			menuList = (ListView) drawerContent.findViewById(R.id.menuList);
		}
		initDrawer(drawer);
	}
	
	private void initDrawer(DrawerLayout drawer) {
		if (drawer == null) {
			return;
		}
		drawer.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        drawerToggle = new ActionBarDrawerToggle(
            activity, drawer,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                 super.onDrawerClosed(drawerView);
                 activity.supportInvalidateOptionsMenu();
                 drawerToggle.syncState();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                 super.onDrawerOpened(drawerView);
                 activity.supportInvalidateOptionsMenu();
                 drawerToggle.syncState();
            }
        };
        drawer.post(new Runnable() {
            @Override
            public void run() {
                drawerToggle.syncState();
            }
        });
		drawer.setDrawerListener(drawerToggle);
		drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
		setHomeIndicator(true);
		initMenuList();
	}
	
	private void initMenuList() {
		if (menuList != null) {
			items = ScreenItem.getItems();
			adapter = new NavigationMenuAdapter(activity, items);
			menuList.setAdapter(adapter);
			menuList.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					ScreenItem item = null;
					if (items != null) {
						item = items.get(position);
					}
					selectItem(position, item);
				}
			});
		}
	}
	
    private void selectItem(int position, ScreenItem item) {
        currentSelectedPosition = position;
        if (adapter != null) {
			adapter.setSelectedPosition(position);
        }
        close();
        if (listener != null) {
			listener.onNavigationDrawerItemSelected(position, item);
        }
    }

	public void toggle() {
		if (isOpened()) {
			close();
		} else {
			open();
		}
	}
	
	public void open() {
		if (drawer != null && drawerContent != null) {
			drawer.openDrawer(drawerContent);
		}	
	}
	
	public void close() {
		if (drawer != null && drawerContent != null) {
			drawer.closeDrawer(drawerContent);
		}		
	}
	
    public boolean isDrawerindIcatorEnabled() {
        if (drawer != null && drawerToggle != null) {
            return drawerToggle.isDrawerIndicatorEnabled();
        }
        return false;
    }
	
	public boolean isOpened() {
		if (drawer != null && drawerContent != null) {
			return drawer.isDrawerOpen(drawerContent);
		}	
		return false;
	}
	
    public void setHomeIndicator(boolean is) {
        if (drawerToggle != null) {
        	drawerToggle.setDrawerIndicatorEnabled(is);
        }
    }
}
