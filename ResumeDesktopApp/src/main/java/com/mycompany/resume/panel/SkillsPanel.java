/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.resume.panel;

import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.dao.inter.UserSkillDaoInter;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import com.mycompany.main.Context;
import com.mycompany.resume.main.Config;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * @author Asus
 */
public final class SkillsPanel extends javax.swing.JPanel {

	private SkillDaoInter skillDao = Context.instanceSkillDao();
	private UserSkillDaoInter userSkillDao = Context.instanceUserSkillDao();

	/**
	 * Creates new form SkillsPanel
	 */
	public SkillsPanel() {
		initComponents();
	}

	public void fillWindow() {
		List<Skill> skills = skillDao.getAll();
		for (Skill skill : skills) {
			cbSkill.addItem(skill);
		}
		fillTable();
	}

	private List<UserSkill> list;

	private void fillTable() {
		list = userSkillDao.getAllSkillByUserId(Config.loggedInUser.getId());
		System.out.println("list fillTable: = " + list);

		Vector<Vector> rows = new Vector<>();
		for (UserSkill l : list) {
			Vector row = new Vector();
			row.add(l.getSkill());
			row.add(l.getPower());
			rows.add(row);
		}
		DefaultTableModel model = new DefaultTableModel(rows, new Vector(Arrays.asList("Skill", "Power")));
		model.setColumnIdentifiers(new String[]{"Skill", "Power"});
		tblSkills.setModel(model);
	}

	public void fillUserComponents() {
		fillWindow();

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		lblSkill = new javax.swing.JLabel();
		txtSkill = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		sliderPower = new javax.swing.JSlider();
		cbSkill = new javax.swing.JComboBox<>();
		btnAdd = new javax.swing.JButton();
		btnDelete = new javax.swing.JButton();
		btnSave = new javax.swing.JButton();
		sss = new javax.swing.JScrollPane();
		tblSkills = new javax.swing.JTable();

		lblSkill.setText("skill:");

		txtSkill.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtSkillActionPerformed(evt);
			}
		});

		jLabel1.setText("power:");

		sliderPower.setMajorTickSpacing(1);
		sliderPower.setMaximum(10);
		sliderPower.setMinimum(1);
		sliderPower.setMinorTickSpacing(1);
		sliderPower.setPaintLabels(true);
		sliderPower.setPaintTicks(true);
		sliderPower.setSnapToTicks(true);
		sliderPower.setToolTipText("power");
		sliderPower.setAutoscrolls(true);
		sliderPower.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		sliderPower.setDoubleBuffered(true);
		sliderPower.setFocusTraversalPolicyProvider(true);

		btnAdd.setText("+");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddActionPerformed(evt);
			}
		});

		btnDelete.setText("-");
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDeleteActionPerformed(evt);
			}
		});

		btnSave.setText("Save");
		btnSave.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSaveActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addGap(11, 11, 11)
												.addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(cbSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addGap(23, 23, 23)
												.addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(36, 36, 36)
												.addComponent(btnSave)
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addGap(18, 18, 18)
												.addComponent(txtSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
												.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(sliderPower, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(24, 24, 24))))
		);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGap(28, 28, 28)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txtSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(cbSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lblSkill))
										.addComponent(sliderPower, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnDelete)
										.addComponent(btnAdd)
										.addComponent(btnSave))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		tblSkills.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][]{
						{},
						{},
						{},
						{}
				},
				new String[]{

				}
		));
		tblSkills.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent evt) {
				tblSkillsPropertyChange(evt);
			}
		});
		sss.setViewportView(tblSkills);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(sss)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(sss, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(38, 38, 38))
		);
	}// </editor-fold>//GEN-END:initComponents

	private void txtSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSkillActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txtSkillActionPerformed

	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
		int index = tblSkills.getSelectedRow();
		UserSkill userSkill = list.get(index);
		userSkillDao.removeUser(userSkill.getId());

		fillTable();
	}//GEN-LAST:event_btnDeleteActionPerformed

	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

		String skillName = txtSkill.getText();
		Skill skill = null;
		if (skillName != null && !skillName.trim().isEmpty()) {
			skill = Skill.builder().id(0).name(skillName).build();
			skillDao.insertSkill(skill);
		} else {
			skill = (Skill) cbSkill.getSelectedItem();
		}
		int power = sliderPower.getValue();
		UserSkill userSkill = UserSkill.builder().id(null).user(Config.loggedInUser).skill(skill).power(power).build();

		userSkillDao.insertUserSkill(userSkill);
		fillWindow();
	}//GEN-LAST:event_btnAddActionPerformed

	private void tblSkillsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblSkillsPropertyChange

	}//GEN-LAST:event_tblSkillsPropertyChange

	private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
		UserSkill selectedUserSkill = list.get(tblSkills.getSelectedRow());
		String skillName = txtSkill.getText();
		Skill skill = null;
		if (skillName != null && !skillName.trim().isEmpty()) {
			skill = Skill.builder().id(0).name(skillName).build();

			skillDao.insertSkill(skill);
		} else {
			skill = (Skill) cbSkill.getSelectedItem();
		}
		int power = sliderPower.getValue();
		selectedUserSkill.setPower(power);
		selectedUserSkill.setSkill(skill);
		userSkillDao.updateUser(selectedUserSkill);

		fillWindow();

	}//GEN-LAST:event_btnSaveActionPerformed


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnAdd;
	private javax.swing.JButton btnDelete;
	private javax.swing.JButton btnSave;
	private javax.swing.JComboBox<Skill> cbSkill;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel lblSkill;
	private javax.swing.JSlider sliderPower;
	private javax.swing.JScrollPane sss;
	private javax.swing.JTable tblSkills;
	private javax.swing.JTextField txtSkill;
	// End of variables declaration//GEN-END:variables
}