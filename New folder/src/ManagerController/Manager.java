/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagerController;

import UI.StaffJFrame;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author DELL
 */
public abstract class Manager {
    private StaffJFrame view = null;
    public StaffJFrame getView() {
        return view;
    }

    public Manager() {
    }
    

    public void setView(StaffJFrame view) {
        if (this.view != view) {
            this.view = view;
            addEvent();
        } else {
            this.view = view;
        }
    }

    

    public abstract void actionSearch();

    

    public abstract void actionEdit();
    private void addEvent() {
        // Hiển thị place holder 
        view.getsearchText().addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                if (view.getsearchText().getText().equals("Search")) {
                    view.getsearchText().setText("");
                    view.getsearchText().setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent evt) {
                if (view.getsearchText().getText().equals("") || view.getsearchText().getText().equals("Search")) {
                    view.getsearchText().setText("Search");
                    view.getsearchText().setForeground(new Color(153, 153, 153));
                }
            }
        });
        view.getsearchText().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    actionSearch();
                }
            }
        });
        
        
        // Sự kiện bấm nút sửa
        view.getBtnEdit().addActionListener(evt -> actionEdit());
        
        
        
    }
}
