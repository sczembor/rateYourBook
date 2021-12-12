
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import pl.polsl.lab.stanislaw.czembor.controller.MainViewController;
import pl.polsl.lab.stanislaw.czembor.exceptions.RatingException;
import pl.polsl.lab.stanislaw.czembor.model.Author;
import pl.polsl.lab.stanislaw.czembor.model.AuthorBuilder;
import pl.polsl.lab.stanislaw.czembor.model.Book;
import pl.polsl.lab.stanislaw.czembor.model.BookBuilder;
import pl.polsl.lab.stanislaw.czembor.model.Rating;
import pl.polsl.lab.stanislaw.czembor.model.RatingBuilder;
import pl.polsl.lab.stanislaw.czembor.view.MainView;

/**
 *
 * @author stani
 */
public class MainWindow extends javax.swing.JFrame {

    private static List<Author> model;

    /**
     * Creates new form NewJFrame
     */
    private List<String[]> getBooksInArrayOfString() {
        List<String[]> books = new ArrayList<>();
        if (model == null) {
            return Collections.EMPTY_LIST;
        } else {
            for (Author author : model) {
                System.err.println(author.getName() + author.getBibliography());
                if (author.getBibliography() != null) {
                    for (Book book : author.getBibliography()) {
                        String row[] = {author.getName(), author.getLastName(), book.getTitle(), book.getGenre(), book.getReleaseDate().toString(), Double.toString(book.getAverageRating())};
                        books.add(row);
                    }
                }
            }
        }
        return books;
    }

    private boolean doesAuthorExsist(String name, String lastName) {
        for (Author author : model) {
            if (name.equals(author.getName()) && lastName.equals(author.getLastName())) {
                return true;
            }
        }
        return false;
    }

    private void clearTable() {
        DefaultTableModel tblModel = (DefaultTableModel) tblBooks.getModel();
        int count = tblModel.getRowCount();
        while (count > 0) {
            tblModel.removeRow(count - 1);
            count = tblModel.getRowCount();
        }
    }

    private void refreshTable() {
        clearTable();
        DefaultTableModel tblModel = (DefaultTableModel) tblBooks.getModel();
        for (String[] row : getBooksInArrayOfString()) {
            tblModel.addRow(row);
        }
    }

    private void rateBook(String name, String lastName, String title) throws RatingException {
        String value = JOptionPane.showInputDialog(this, "Enter rating value (0-10)", null);
        Rating newRating = new RatingBuilder().setValue(Integer.valueOf(value)).setDescription("").createRating();
        for (Author author : model) {
            if (name.equals(author.getName()) && lastName.equals(author.getLastName())) {
                for (Book book : author.getBibliography()) {
                    if (title.equals(book.getTitle())) {
                        book.addRating(newRating);
                        return;
                    }
                }
            }
        }

    }

    private void addBook() {
        String name = txtAddName.getText();
        String lastName = txtAddLastName.getText();
        LocalDate date = Instant.ofEpochMilli(txtAddPublicationDate.getDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        Book newBook = new BookBuilder().setTitle(txtAddTitle.getText()).setReleaseDate(date).setGenre("Horror").setRatings(null).createBook();
        for (Author author : model) {
            if (name.equals(author.getName()) && lastName.equals(author.getLastName())) {
                author.addBook(newBook);
                System.err.println("dodanie do autora");
                return;
            }
        }
        System.err.println("Nowy autor");
        model.add(new AuthorBuilder().setName(name).setLastName(lastName).setBibliography(new ArrayList<>(List.of(newBook))).createAuthor());

    }

    public void deleteBook(String name, String lastName, String title) {
        for (Author author : model) {
            System.err.println("delete book");
            if (name.equals(author.getName()) && lastName.equals(author.getLastName())) {
                author.deleteBook(title);
                return;
            }
        }

    }

    public MainWindow() {
        initComponents();
        refreshTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        BrowsePanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTite = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBooks = new javax.swing.JTable();
        btnRate1 = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        AddPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtAddName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtAddLastName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAddTitle = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtAddGenre = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtAddPublicationDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        jDialog1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Author's Name");

        jTextField4.setEnabled(false);
        jTextField4.setMinimumSize(new java.awt.Dimension(50, 20));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel6.setText("Author's Last Name");

        jTextField5.setEnabled(false);
        jTextField5.setMinimumSize(new java.awt.Dimension(50, 20));

        jLabel7.setText("Title");

        jTextField6.setEnabled(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jButton2.setText("Rate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField6))
                        .addGap(0, 267, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        jDialog1.getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Author's Name");

        txtName.setMinimumSize(new java.awt.Dimension(50, 20));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Author's Last Name");

        txtLastName.setMinimumSize(new java.awt.Dimension(50, 20));

        jLabel4.setText("Title");

        txtTite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiteActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTite))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(135, Short.MAX_VALUE)
                    .addComponent(btnSearch)
                    .addGap(1, 1, 1)))
        );

        tblBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Last Name", "Title", "Genre", "Release Date", "Avg. Rating"
            }
        ));
        jScrollPane2.setViewportView(tblBooks);

        btnRate1.setText("Rate");
        btnRate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRate1ActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BrowsePanelLayout = new javax.swing.GroupLayout(BrowsePanel);
        BrowsePanel.setLayout(BrowsePanelLayout);
        BrowsePanelLayout.setHorizontalGroup(
            BrowsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BrowsePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BrowsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BrowsePanelLayout.createSequentialGroup()
                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addComponent(btnRate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(36, 36, 36)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        BrowsePanelLayout.setVerticalGroup(
            BrowsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BrowsePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(BrowsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRate1)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addGap(40, 40, 40))
        );

        jTabbedPane1.addTab("Browse", BrowsePanel);

        jLabel8.setText("Author's Name");

        jLabel9.setText("Author's Last Name");

        jLabel10.setText("Title");

        btnAdd.setText("Save");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel16.setText("Genre");

        jLabel17.setText("Publication Date");

        txtAddPublicationDate.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAddName)
                    .addComponent(txtAddLastName)
                    .addComponent(txtAddTitle)
                    .addComponent(txtAddGenre)
                    .addComponent(txtAddPublicationDate, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addContainerGap(277, Short.MAX_VALUE))
            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtAddName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtAddLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtAddTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtAddGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(txtAddPublicationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addContainerGap())
        );

        javax.swing.GroupLayout AddPanelLayout = new javax.swing.GroupLayout(AddPanel);
        AddPanel.setLayout(AddPanelLayout);
        AddPanelLayout.setHorizontalGroup(
            AddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AddPanelLayout.setVerticalGroup(
            AddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add", AddPanel);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 600, 470));
        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        jLabel1.setText("Library");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        //default title and icon
        if (txtAddName.getText().equals("") || txtAddLastName.getText().equals("") || txtAddTitle.getText().equals("") || txtAddGenre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Fill all the fields before proceding!");
        } else {
            if (jTabbedPane1.getTitleAt(1).equals("Add")) {
                addBook();
                JOptionPane.showMessageDialog(this, "Record added succesfully");
            } else {
                int row = tblBooks.getSelectedRow();
                String name = (tblBooks.getModel().getValueAt(row, 0).toString());
                String lastName = (tblBooks.getModel().getValueAt(row, 1).toString());
                String title = (tblBooks.getModel().getValueAt(row, 2).toString());
                deleteBook(name, lastName, title);
                addBook();
                JOptionPane.showMessageDialog(this, "Record edited succesfully");
                jTabbedPane1.setTitleAt(1, "Add");
            }
            jTabbedPane1.setSelectedIndex(0);
            clearEditable();
            refreshTable();
        }


    }//GEN-LAST:event_btnAddActionPerformed

    private void txtTiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiteActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRate1ActionPerformed
        // TODO add your handling code here:
        int row = tblBooks.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row before proceding");
        } else {
            // do whatever you need to do with the data from the row
            String name = (tblBooks.getModel().getValueAt(row, 0).toString());
            String lastName = (tblBooks.getModel().getValueAt(row, 1).toString());
            String title = (tblBooks.getModel().getValueAt(row, 2).toString());

            try {
                rateBook(name, lastName, title);
                JOptionPane.showMessageDialog(this, "Rating added succesfully");
                refreshTable();
            } catch (RatingException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }

    }//GEN-LAST:event_btnRate1ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        int row = tblBooks.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row before proceding");
        } else {
            // do whatever you need to do with the data from the row
            String name = (tblBooks.getModel().getValueAt(row, 0).toString());
            String lastName = (tblBooks.getModel().getValueAt(row, 1).toString());
            String title = (tblBooks.getModel().getValueAt(row, 2).toString());
            String genre = (tblBooks.getModel().getValueAt(row, 3).toString());
            String releaseDate = (tblBooks.getModel().getValueAt(row, 4).toString());
            txtAddName.setText(name);
            txtAddLastName.setText(lastName);
            txtAddTitle.setText(title);
            txtAddGenre.setText(genre);
                
            LocalDate localDate = LocalDate.of(Integer.valueOf(releaseDate.substring(0, 4)), Integer.valueOf(releaseDate.substring(5, 7)), Integer.valueOf(releaseDate.substring(8, 10)));
            txtAddPublicationDate.setDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));

            jTabbedPane1.setSelectedIndex(1);
            jTabbedPane1.setTitleAt(1, "Edit");
        }


    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblBooks.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row before proceding");
        } else {
            // do whatever you need to do with the data from the row
            String name = (tblBooks.getModel().getValueAt(row, 0).toString());
            String lastName = (tblBooks.getModel().getValueAt(row, 1).toString());
            String title = (tblBooks.getModel().getValueAt(row, 2).toString());

            deleteBook(name, lastName, title);
            JOptionPane.showMessageDialog(this, "Book has been deleted");
            refreshTable();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        try {
            Rating shiningRating1 = new RatingBuilder().setValue(7).setDescription("Great book").createRating();
            Rating shiningRating2 = new RatingBuilder().setValue(8).setDescription("Terrifying").createRating();

            List<Rating> ratingsShining = new ArrayList<>();
            ratingsShining.add(shiningRating1);
            ratingsShining.add(shiningRating2);
            Book shining = new BookBuilder().setTitle("Shining").setReleaseDate(LocalDate.of(1985, 05, 11)).setGenre("Horror").setRatings(ratingsShining).createBook();
            List<Book> tmpBooks = new ArrayList<>();
            tmpBooks.add(shining);
            Author king = new AuthorBuilder().setName("Steven").setLastName("King").setBibliography(tmpBooks).createAuthor();
            model = new ArrayList<>();
            model.add(king);

//            MainView view = new MainView();
//            MainViewController controller = new MainViewController(view, authors);
//            controller.displayMenu();
//            controller.updateView();
        } catch (RatingException e) {
            System.out.println(e);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddPanel;
    private javax.swing.JPanel BrowsePanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRate1;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTable tblBooks;
    private javax.swing.JTextField txtAddGenre;
    private javax.swing.JTextField txtAddLastName;
    private javax.swing.JTextField txtAddName;
    private com.toedter.calendar.JDateChooser txtAddPublicationDate;
    private javax.swing.JTextField txtAddTitle;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTite;
    // End of variables declaration//GEN-END:variables

    private void clearEditable() {
        txtAddGenre.setText("");
        txtAddName.setText("");
        txtAddLastName.setText("");
        txtAddTitle.setText("");
        txtAddPublicationDate.setDate(null);
    }

}