package spdvi;

import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DevMike
 */

public class MainForm extends javax.swing.JFrame {
    
    final static String fileName = "src/spdvi/users.txt";
    ArrayList<User> users = new ArrayList<User>();
    private boolean confirmSave = false;
    private boolean dataChanged = false;
    private JList<User> lstUsers;
    
    JFileChooser fileChooser;
    //Nos dice el direcotrio home de nuestro usuario.
    //Tambien iria bien en Linux.
    String userFolder = System.getProperty("user.home");
    String ubi = "\\AppData\\Local\\UserList2\\images\\";
    
    
    /**
     * Creates new form MainFrame
     */
    public MainForm() {
        initComponents();
        lstUsers = new JList<User>();
        jScrollPane1.setViewportView(lstUsers);
        lstUsers.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUsersValueChanged(evt);
            }
        });
    }

    public boolean isConfirmSave() {
        return confirmSave;
    }

    public void setConfirmSave(boolean confirmSave) {
        this.confirmSave = confirmSave;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtId = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtBirthDate = new javax.swing.JTextField();
        radGenderMale = new javax.swing.JRadioButton();
        radGenderFemale = new javax.swing.JRadioButton();
        btnInsert = new javax.swing.JButton();
        chkIsAlive = new javax.swing.JCheckBox();
        btnLoadIntoList = new javax.swing.JButton();
        btnDeleteSelected = new javax.swing.JButton();
        btnSaveListToFile = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblImage = new javax.swing.JLabel();
        btnImage = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mniExit = new javax.swing.JMenuItem();
        mnuCRUD = new javax.swing.JMenu();
        mniInsert = new javax.swing.JMenuItem();
        mniLoad = new javax.swing.JMenuItem();
        mniUpdate = new javax.swing.JMenuItem();
        mniDelete = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Manager");
        setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        setLocation(new java.awt.Point(400, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtId.setText("Id");
        txtId.setName(""); // NOI18N
        txtId.setNextFocusableComponent(txtFirstName);
        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdFocusGained(evt);
            }
        });

        txtFirstName.setText("FirstName");
        txtFirstName.setNextFocusableComponent(txtLastName);
        txtFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFirstNameFocusGained(evt);
            }
        });

        txtLastName.setText("LastName");
        txtLastName.setNextFocusableComponent(txtBirthDate);
        txtLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLastNameFocusGained(evt);
            }
        });

        txtBirthDate.setText("2000-01-01");
        txtBirthDate.setNextFocusableComponent(chkIsAlive);
        txtBirthDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBirthDateFocusGained(evt);
            }
        });

        buttonGroup1.add(radGenderMale);
        radGenderMale.setSelected(true);
        radGenderMale.setText("Male");
        radGenderMale.setNextFocusableComponent(radGenderFemale);

        buttonGroup1.add(radGenderFemale);
        radGenderFemale.setText("Female");
        radGenderFemale.setNextFocusableComponent(btnInsert);

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        chkIsAlive.setText("Alive");
        chkIsAlive.setNextFocusableComponent(btnInsert);
        chkIsAlive.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkIsAliveStateChanged(evt);
            }
        });
        chkIsAlive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkIsAliveActionPerformed(evt);
            }
        });

        btnLoadIntoList.setText("Load");
        btnLoadIntoList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadIntoListActionPerformed(evt);
            }
        });

        btnDeleteSelected.setText("Delete");
        btnDeleteSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSelectedActionPerformed(evt);
            }
        });

        btnSaveListToFile.setText("Save");
        btnSaveListToFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveListToFileActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("txtId");

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("txtFirstName");

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("txtLastName");

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("txtBirthDate");

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("radGenderMale");

        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("radGenderFemale");

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("chkIsAlive");

        btnImage.setText("Open Image");
        btnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageActionPerformed(evt);
            }
        });

        mnuFile.setText("File");

        mniExit.setMnemonic('E');
        mniExit.setText("Exit");
        mniExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniExitActionPerformed(evt);
            }
        });
        mnuFile.add(mniExit);

        jMenuBar1.add(mnuFile);

        mnuCRUD.setText("CRUD");

        mniInsert.setText("Insert");
        mniInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniInsertActionPerformed(evt);
            }
        });
        mnuCRUD.add(mniInsert);

        mniLoad.setText("Load");
        mniLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLoadActionPerformed(evt);
            }
        });
        mnuCRUD.add(mniLoad);

        mniUpdate.setText("Update");
        mniUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniUpdateActionPerformed(evt);
            }
        });
        mnuCRUD.add(mniUpdate);

        mniDelete.setText("Delete");
        mniDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDeleteActionPerformed(evt);
            }
        });
        mnuCRUD.add(mniDelete);

        jMenuBar1.add(mnuCRUD);

        mnuHelp.setText("Help");
        jMenuBar1.add(mnuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(chkIsAlive)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel7))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel6)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(radGenderMale)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(radGenderFemale)))
                                            .addComponent(jLabel5))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(34, 34, 34)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUpdate)
                                .addGap(8, 8, 8))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnLoadIntoList, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnSaveListToFile, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeleteSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImage)
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(radGenderMale)
                                            .addComponent(radGenderFemale)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(12, 12, 12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(chkIsAlive)
                                        .addComponent(jLabel7))
                                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnInsert)
                                    .addComponent(btnUpdate)))
                            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLoadIntoList)
                            .addComponent(btnDeleteSelected)
                            .addComponent(btnSaveListToFile)
                            .addComponent(btnImage))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstUsersValueChanged(javax.swing.event.ListSelectionEvent evt) {
        User selectedUser = lstUsers.getSelectedValue();
        if (selectedUser != null) {
            for (User u: users) {
                if (u.getId().equals(selectedUser.getId())) {
                    txtId.setText(u.getId());
                    txtFirstName.setText(u.getFirstName());
                    txtLastName.setText(u.getLastName());
                    String formattedDate = u.getBirthDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    txtBirthDate.setText(formattedDate);
                    if ("Male".equals(u.getGender())) {
                        radGenderMale.setSelected(true);
                        //radGenderFemale.setSelected(false);
                    }
                    else if ("Female".equals(u.getGender())) {
                        //radGenderMale.setSelected(false);
                        radGenderFemale.setSelected(true);
                    }
                    else {
                        //ERROR: Throw exception
                    }
                    chkIsAlive.setSelected(u.isIsAlive());    
                }
            }            
        }
    }
    
    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed

        String path;
        try {
            path = fileChooser.getSelectedFile().getAbsolutePath();
            
        } catch (NullPointerException npe) {
            path = "C:\\Users\\Alumne\\Documents\\MEGA\\AAA_GradoSuperior\\2n_Curso\\1r_Trimestre\\Desenvolupament d'interficies\\Tema_3\\jpg\\jpg\\jpg\\no-image.jpg";
        }
        
        LocalDate birthDate = LocalDate.now();
        try {
            birthDate = LocalDate.parse(txtBirthDate.getText());
            
            String maleOrFemale;
            if (radGenderMale.isSelected()) {
                maleOrFemale = "Male";
            }
            else 
                maleOrFemale = "Female";
            // TODO: Write a line of code to create newUser Initialized with the corresponding data
            
            User newUser = new User(txtId.getText(), txtFirstName.getText(), txtLastName.getText(), birthDate, maleOrFemale, chkIsAlive.isSelected(), path);
            
            users.add(newUser);
            
            UpdateUserListView();
            dataChanged = true;
        } catch (Exception ex) {
            ErrorMessageDialog encuesta = new ErrorMessageDialog(this, true);
            encuesta.getLblMessage().setText(ex.getMessage());
            encuesta.setVisible(true);
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void txtIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusGained
        // TODO add your handling code here:
        txtId.selectAll();
    }//GEN-LAST:event_txtIdFocusGained

    private void txtFirstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFirstNameFocusGained
        txtFirstName.selectAll();
    }//GEN-LAST:event_txtFirstNameFocusGained

    private void txtLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLastNameFocusGained
        txtLastName.selectAll();
    }//GEN-LAST:event_txtLastNameFocusGained

    private void txtBirthDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBirthDateFocusGained
        txtBirthDate.selectAll();
    }//GEN-LAST:event_txtBirthDateFocusGained

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //SwingUtilities.getRootPane(this).setDefaultButton(btnInsert);
        
        /*try {
            users.clear();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String currentLine = reader.readLine();
            while (currentLine != null) {
                String[] fields = currentLine.split(",");
                User user = new User(fields[0], fields[2], fields[1],
                        LocalDate.parse(fields[3]), fields[4],
                        fields[5].equals("Alive"), fields[6]);                 
                users.add(user);
                currentLine = reader.readLine();
            }
            UpdateUserListView();
        }
        catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }*/
        
        /*File imagesFolder = new File("src\\Images");
        
        File[] imagesFiles = imagesFolder.listFiles();
        DefaultListModel imagesListModel = new DefaultListModel();
        
        for(File f: imagesFiles)
            imagesListModel.addElement(f.getName());
        
        lstOptions.setModel(imagesListModel);*/
    }//GEN-LAST:event_formWindowOpened

    private void btnLoadIntoListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadIntoListActionPerformed
        try {
            users.clear();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String currentLine = reader.readLine();
            while (currentLine != null) {
                String[] fields = currentLine.split(",");
                User user = new User(fields[0], fields[2], fields[1],
                        LocalDate.parse(fields[3]), fields[4],
                        fields[5].equals("Alive"), fields[6]); 
               
                users.add(user);
                currentLine = reader.readLine();
            }
            reader.close();
            UpdateUserListView();
        }
        catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        
    }//GEN-LAST:event_btnLoadIntoListActionPerformed

    private void btnDeleteSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSelectedActionPerformed
        User selectedUser = lstUsers.getSelectedValue();
        //int lastIndex = selectedUser.indexOf(":");
        //int selectedUserId = Integer.parseInt( selectedUser.substring(0, lastIndex-1) );
        //String selectedUserId = selectedUser.substring(0, lastIndex);

        // TODO: Buscar en la lista users el objeto User que tiene como Id == selectedUserId y eliminarlo de la lista
        
        users.remove(selectedUser);
        
//        for (User u: users) {
//            if (u.getId().equals(selectedUser.getId())) {
//                users.remove(u);
//                break;
////                DefaultListModel usersListModel = (DefaultListModel)lstUsers.getModel();
////                try{
////                    usersListModel.removeElement(u.toString());
////                }
////                catch(NullPointerException npe) {
////                    npe.printStackTrace();
////                }
//            }
//        }
        
//        DefaultListModel usersListModel = (DefaultListModel)lstUsers.getModel();
        UpdateUserListView();
        dataChanged = true;
    }//GEN-LAST:event_btnDeleteSelectedActionPerformed

    private void btnSaveListToFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveListToFileActionPerformed
        ConfirmSaveDialog saveDialog = new ConfirmSaveDialog(this, true);
        saveDialog.setVisible(true);
        
        if (this.confirmSave) {
            SaveToFile();
            dataChanged = false;
        }
    }//GEN-LAST:event_btnSaveListToFileActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        for (User u: users) {
            if (u.getId().equals(txtId.getText())) {
                u.setFirstName(txtFirstName.getText());
                u.setLastName(txtLastName.getText());
                u.setBirthDate(LocalDate.parse(txtBirthDate.getText()));
                u.setGender(radGenderMale.isSelected() ? "Male" : "Female");
                u.setIsAlive(chkIsAlive.isSelected());
                UpdateUserListView();
                dataChanged = true;
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        if (dataChanged) {
            ConfirmSaveDialog saveDialog = new ConfirmSaveDialog(this, true);
            saveDialog.setVisible(true);
            if (confirmSave)
                SaveToFile();
        }
    }//GEN-LAST:event_formWindowClosing

    private void mniInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniInsertActionPerformed
        btnInsert.doClick();
    }//GEN-LAST:event_mniInsertActionPerformed

    private void mniExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniExitActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_mniExitActionPerformed

    private void mniLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLoadActionPerformed
        btnLoadIntoList.doClick();
    }//GEN-LAST:event_mniLoadActionPerformed

    private void mniUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniUpdateActionPerformed
        btnUpdate.doClick();       
    }//GEN-LAST:event_mniUpdateActionPerformed

    private void mniDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDeleteActionPerformed
        btnDeleteSelected.doClick();
    }//GEN-LAST:event_mniDeleteActionPerformed

    private void chkIsAliveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkIsAliveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkIsAliveActionPerformed

    private void chkIsAliveStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkIsAliveStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_chkIsAliveStateChanged

    private void btnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageActionPerformed
        //Es para que te salga un Dialog para seleccionar un archivo del sistema.
        fileChooser = new JFileChooser();
        //Y mostramos la ventana para su busqueda.
        
        //el JFileChooser devuelte uno de tres valores, si pones el 
        //APPROVE_OPTION hacemos que si seleccionamos un archivo y le damos a
        //cancelar no mostrara su path, simplemente no saldra nada.
        int returnOption =  fileChooser.showOpenDialog(this);
        
        String path = fileChooser.getSelectedFile().getAbsolutePath();
        
        if(returnOption == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedImage buIm = ImageIO.read(new File(path));
                ImageIcon icon = resizeImageIcon(buIm, lblImage.getWidth(), lblImage.getHeight());
                lblImage.setIcon(icon);
            } catch(IOException ioe) {
                ioe.printStackTrace();
            }
        }
            
    }//GEN-LAST:event_btnImageActionPerformed

    private ImageIcon resizeImageIcon (BufferedImage originalImage, int desiredWidth, int desiredHeight) {
        int newHeight = 0;    
        int newWidth = 0;
        float aspectRatio = (float)originalImage.getWidth() / originalImage.getHeight();
        if (originalImage.getWidth() > originalImage.getHeight()) {
            newWidth = desiredWidth;
            newHeight = Math.round( desiredWidth / aspectRatio);                
        }
        else {
            newHeight = desiredHeight;
            newWidth = Math.round(desiredHeight * aspectRatio);
        }
        Image resultingImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage outputImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        ImageIcon imageIcon = new ImageIcon(outputImage);
        return imageIcon;
    }
    
    private void UpdateUserListView() {
        //usersListModel = (DefaultListModel)lstUsers.getModel();
        //https://stackoverflow.com/questions/10375115/jlist-getmodel-classcastexception
//        DefaultListModel usersListModel = (DefaultListModel)lstUsers.getModel();
//        usersListModel.clear();
//        
//        for(User u: users) {
//            usersListModel.addElement(u.toString());
//        }
        DefaultListModel<User> usersListModel = new DefaultListModel<User>();
        for(User u: users) {
            usersListModel.addElement(u);
        }
        lstUsers.setModel(usersListModel);      
    }
    
    private void SaveToFile() {
       
        String path;
        String noImage;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for(User u: users) {
                
                String formattedDate = u.getBirthDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String userString = u.getId() + "," + u.getLastName() + ","
                        + u.getFirstName() + ","
                        + formattedDate
                        + "," + u.getGender() + "," + (u.isIsAlive() ? "Alive" : "Dead") 
                        + "," + u.getNameImage() + System.lineSeparator();
                writer.append(userString);
                
                
                //path = fileChooser.getSelectedFile().getName();
                //path = u.getNameImage();
                
                //Ahora vamos a guardar una imagen que hemos seleccionado en la carpeta
                //de nuestro home.
                //Esa carpeta de UserList2 en AppData/Local la he creado manualmente.
                //noImage = fileChooser.getSelectedFile().getAbsolutePath();
                BufferedImage bufferedImage = ImageIO.read(new File(u.getNameImage()));
                String outputImageAbsolutePath = userFolder + ubi + u.getId() + ".jpg";
                File outputImage = new File(outputImageAbsolutePath);
                //Creamos la imagen con la extension que le hemos puesto en la ruta
                //que hemos creado.
                ImageIO.write(bufferedImage, "jpg", outputImage);
            }
            writer.close();            
        } catch (NullPointerException npe) {
            path = "no-image.jpg";
            noImage = "no-image.jpg";
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
                
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteSelected;
    private javax.swing.JButton btnImage;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLoadIntoList;
    private javax.swing.JButton btnSaveListToFile;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkIsAlive;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JMenuItem mniDelete;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniInsert;
    private javax.swing.JMenuItem mniLoad;
    private javax.swing.JMenuItem mniUpdate;
    private javax.swing.JMenu mnuCRUD;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JRadioButton radGenderFemale;
    private javax.swing.JRadioButton radGenderMale;
    private javax.swing.JTextField txtBirthDate;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables

}
