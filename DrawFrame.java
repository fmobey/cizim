

import javax.swing.*;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;

public class DrawFrame extends JFrame
{
  private JMenuBar menuBar = new JMenuBar();
  private JMenu shapeMenu = new JMenu("CİZİM");
  private String[] shapeOptions = {"CİZGİ", "KARE", "NOKTA"};
  private JMenu methodMenu = new JMenu();
  private String[] methodOptions = {};
  private String[] colors = {"Black"};

  DrawPanel panel = new DrawPanel();

  public DrawFrame()
  {
    super("CBS - FURKAN METİN OĞUZ");
    setJMenuBar(menuBar);
    add(panel, BorderLayout.CENTER);
    addMenuItemsToJMenu(shapeMenu, shapeOptions);
    addMenuItemsToJMenu(methodMenu, methodOptions);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 500);
    setVisible(true);
  }

  public void addMenuItemsToJMenu(JMenu menu, String[] arr) {
    MenuHandler handler = new MenuHandler();
    for (int i = 0; i < arr.length; i++) {
      JMenuItem menuItem = new JMenuItem(arr[i]);
      menu.add(menuItem);
      menuItem.addActionListener(handler);
    }
    menuBar.add(menu);
  }
  private class MenuHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      String actionCommand = event.getActionCommand();
      switch (actionCommand) {
        case "CİZGİ":
          panel.setCurrentShapeType("CİZGİ");
          break;
        case "KARE":
          panel.setCurrentShapeType("KARE");
          break;
        case "NOKTA":
          panel.setCurrentShapeType("NOKTA");
          break;

      }
    }
  }
}
