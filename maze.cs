using System;
using System.Drawing;
using System.Collections; 
using System.ComponentModel; 
using System.Windows.Forms; 
using System.Data;


namespace DFSAlgorithmMaze 
{
	
	// YY:DimensionsDialog
	/// <summary>
	/// Summary description for DimensionsDialog.
	/// </summary>
	 class DimensionsDialog : System.Windows.Forms.Form
	{
		public System.Windows.Forms.Button OKButton;
		public System.Windows.Forms.Button CancelButton;
		public System.Windows.Forms.Label label1;
		public System.Windows.Forms.Label label2;
		public System.Windows.Forms.NumericUpDown numericUpDown1; 
		public System.Windows.Forms.NumericUpDown numericUpDown2;
		/// <summary>
		/// Required designer variable.
		/// </summary>

		private System.ComponentModel.Container components = null;
		public DimensionsDialog() 
		{
			//
			// Required for Windows Form Designer support 
			//
			InitializeComponent();
			//
			// TODO: Add any constructor code after InitializeComponent call 
			//
		}

		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		protected override void Dispose( bool disposing )
		{
			if( disposing ) 
			{
				if(components != null) 
				{
					components.Dispose(); 
				}
			}
			base.Dispose( disposing ); 
		}

		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify 
		/// the contents of this method with the code editor. 
		/// </summary>
		private void InitializeComponent()
		{
			this.OKButton = new System.Windows.Forms.Button(); 
			this.CancelButton = new System.Windows.Forms.Button(); 
			this.label1 = new System.Windows.Forms.Label();
			this.label2 = new System.Windows.Forms.Label(); 
			this.numericUpDown1 = new System.Windows.Forms.NumericUpDown(); 
			this.numericUpDown2 = new System.Windows.Forms.NumericUpDown();
			((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).BeginInit();
			((System.ComponentModel.ISupportInitialize)(this.numericUpDown2)).BeginInit ();
			this.SuspendLayout();
			//
			// OKButton
			//
			this.OKButton.DialogResult = System.Windows.Forms.DialogResult.OK; 
			this.OKButton.Location = new System.Drawing.Point(32, 104); 
			this.OKButton.Name = "OKButton";
			this.OKButton.Size = new System.Drawing.Size(72, 26); 
			this.OKButton.TabIndex = 0;
			this.OKButton.Text = "OK";
			//
			// CancelButton
			//
			this.CancelButton.DialogResult =System.Windows.Forms.DialogResult.Cancel;
			this.CancelButton.Location = new System.Drawing.Point(152, 104); 
			this.CancelButton.Name = "CancelButton";
			this.CancelButton.Size = new System.Drawing.Size(70, 26); 
			this.CancelButton.TabIndex = 1;
			this.CancelButton.Text = "Cancel";
			//
			// label1
			//
			this.label1.Location = new System.Drawing.Point(24, 24); 
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(120, 18); 
			this.label1.TabIndex = 2;
			this.label1.Text = "迷宫的阶数(n×n):";
			//
			// label2
			//
			this.label2.Location = new System.Drawing.Point(24, 64); 
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(120, 18); 
			this.label2.TabIndex = 3;
			this.label2.Text = "宫格大小(像素):";
			//
			// numericUpDown1
			//
			this.numericUpDown1.Location = new System.Drawing.Point(160, 16);
			this.numericUpDown1.Name = "numericUpDown1"; 
			this.numericUpDown1.Size = new System.Drawing.Size(58, 21); 
			this.numericUpDown1.TabIndex = 4;
			//
			// numericUpDown2
			//
			this.numericUpDown2.Location = new System.Drawing.Point(160, 56); 
			this.numericUpDown2.Name = "numericUpDown2"; 
			this.numericUpDown2.Size = new System.Drawing.Size(58, 21); 
			this.numericUpDown2.TabIndex = 5;
			//
			// DimensionsDialog
			//
			this.AutoScaleBaseSize = new System.Drawing.Size(6, 14); 
			this.ClientSize = new System.Drawing.Size(266, 151); 
			this.Controls.Add(this.numericUpDown2); 
			this.Controls.Add(this.numericUpDown1); 
			this.Controls.Add(this.label2);
			this.Controls.Add(this.label1); 
			this.Controls.Add(this.CancelButton); 
			this.Controls.Add(this.OKButton);
			this.FormBorderStyle =System.Windows.Forms.FormBorderStyle.FixedDialog; 
			this.Name = "DimensionsDialog";
			this.Text = "生成迷宫设置";			
			((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).EndInit() ;
			((System.ComponentModel.ISupportInitialize)(this.numericUpDown2)).EndInit() ;
			this.ResumeLayout(false);
		}

		
	}

    class CbobsMap
    {
            //保存地图的存储器(一个 2 维整数数组)
 			 static  const  int  map[MAP_HEIGHT][MAP_WIDTH];                  
 			 static  const  int  m_iMapWidth;//地图的宽度                   
 			 static  const  int  m_iMpaHeight;//地图的高度                   
 			   //起始点在数组中的下标
 			 static  const  int  m_iStartX;                   
 			 static  const  int  m_iStartY;
 			   //终点的数组下标
 			 static  const  int  m_iEndX;                   
 			 static  const  int  m_iEndY;
 			 
 			     //如果需要,可以利用这一数组作为 Bob 走过的路程的存储器
 			  int  memory[MAP_HEIGHT][MAP_WIDTH];
 			                   
 			   CbobsMap()
 			  {  
 			  	ResetMemory();
 			  }
 			     //利用一个字符串来记录 Bob 行进的方向,其中每一个字符代表 Bob 所走的一步                   
 			  //检查 Bob 离开出口还有多远,返回一个与到达出口距离成正比的适应性分数	
 			  double  TestRoute(const  Vector<int>  &vecPath,CbobsMap  &memory);
 			   //Render 函数利用 Windows  GDI 在一个给定的作图表面上呈现地图
 			  void  Render(const  int  cxClient,const  int  cyClient,HDC  surface); 
 			     //画出能够存放于存储器中的任意路径
 			  void  MemoryRender(const  int  cxClient,const  int  cyClient,HDC  surface);
 			              void  ResetMemory(); 
 	}

 		interface CgaBob
 			{ 
				  //基因组群休         
				 vector<SGenome>  m_vecGenomes;         
         		 //群体大小         
 				int m_iPopSize;
                double  m_dCrossoverRate;                  
 				double  m_dMutationRate;                 
   				//决定每个染色体含有多少个位         
 				int  m_iChromoLength;
   				//决定每个基因有多少个位
         		int    m_iGeneLength;
         		int    m_iFittestGenome;
         		double   m_dBestFitnessScore;                 
  				double  m_dTotalFitnessScore;         
         		int   m_iGeneration;
		 		//为 map 类创建一个实例
		 		//我们使用另一个 CbobsMap 对象来保存每一代中的最佳路线         
		 		//它是一些 Bob 经过的小方格的数组
         		//仅用于显示
  				CBobsMap m_BobsBrain;
 				//检测运行是否仍在进行
 				bool   m_bBusy;
 				void   Mutate(vector<int>  &vecBits);
 				void   Crossover(const  vector<int>  &mum,
 				const  vector<int>  &dad,
 				vector<int>    &baby1,
 				vector<int>    &baby2);
 				SGenome& RouletteWheelSelection(); 
 				  //用新的适应性分数更新基因组原有的适应性分数 
 				 //并计算群体的最高适应性分数和适应性分数最高的那个成员 
 				 void  UpdateFitnessScores(); 
 				 //把每个位译成为方向(用十进制整数代表)
 				 vector<int> Decode(const  vector<int>  &bits);  
 				   //把位转换为十进制整数
 				  int  BinToInt(const  vector<int>  &v);
 				     //创建一个随机的二进制位串的初始群体
 				  void CreateStartPopulation();
 				   CgaBob(double  cross_rat, double  mut_rat, int pop_size,int num_bits, int gene_len):
 				  m_dCrossoverRate(cross_rat),m_dMutationRate(mut_rat),m_iPopSize(pop_size),m_iChromoLength(num_bits),m_dTotalFitnessScore(0.0),
 				  m_iGeneration(0),m_iGeneLength(gene_len),m_bBusy(false)
 				  {
 				  	               CreateStartPopulation();
 				  	       	 	 }
 				  	void  Run(HWND  hwnd);
 				  	void  Render(int  cxClient,  int  cyClient,  HDC  surface);
 				  	void  Epoch();
 				  //可访问方法
 				 int  Generation(){return  m_iGeneration;}         
 				 int  GetFittest(){return  m_iFittestGenome;}   
 				 bool Started(){return  m_bBusy;}   
 				 void Stop(){m_bBusy  =  false;}
 			}
 

		
 	//YY: RadomMaze
 	class RandomMaze : System.Windows.Forms.Form 
	{
		private System.Windows.Forms.Button button1;
		public System.Windows.Forms.NumericUpDown wallsnumericUpDown; 
		private System.Windows.Forms.Button button2;
		public System.Windows.Forms.NumericUpDown numericUpDown1; 
		public System.Windows.Forms.NumericUpDown numericUpDown2; 
		public System.Windows.Forms.Label label4;
		public System.Windows.Forms.Label label5;
		public System.Windows.Forms.Label label1;
		private System.ComponentModel.IContainer components;

		public RandomMaze() 
		{
			//
			// Windows 窗体设计器支持所必需的
			//
			InitializeComponent();
			//
			// TODO: 在 InitializeComponent 调用后添加任何构造函数代码 
			//
		}
		/// <summary>
		/// 清理所有正在使用的资源。
		/// </summary>
		protected override void Dispose( bool disposing )
		{
			if( disposing )
			{
				if(components != null) 
				{
					components.Dispose();
				} 
			}
			base.Dispose( disposing );
		}
		#region Windows 窗体设计器生成的代码
		/// <summary>
		/// 设计器支持所需的方法 - 不要使用代码编辑器修改 
		/// 此方法的内容。
		/// </summary>
		private void InitializeComponent()
		{
			this.button1 = new System.Windows.Forms.Button(); 
			this.wallsnumericUpDown = new System.Windows.Forms.NumericUpDown(); 
			this.button2 = new System.Windows.Forms.Button(); 
			this.numericUpDown1 = new System.Windows.Forms.NumericUpDown(); 
			this.numericUpDown2 = new System.Windows.Forms.NumericUpDown(); 
			this.label4 = new System.Windows.Forms.Label();
			this.label5 = new System.Windows.Forms.Label();
			this.label1 = new System.Windows.Forms.Label();
			((System.ComponentModel.ISupportInitialize)(this.wallsnumericUpDown)).Begin Init();
			((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).BeginInit ();
			((System.ComponentModel.ISupportInitialize)(this.numericUpDown2)).BeginInit ();
			this.SuspendLayout();
			//
			// button1
			//
			this.button1.DialogResult = System.Windows.Forms.DialogResult.OK; 
			this.button1.Location = new System.Drawing.Point(56, 160); 
			this.button1.Name = "button1";
			this.button1.Size = new System.Drawing.Size(72, 24); 
			this.button1.TabIndex = 1;
			this.button1.Text = "OK";
			//
			// wallsnumericUpDown
			//
			this.wallsnumericUpDown.Location = new System.Drawing.Point(200,112);
			this.wallsnumericUpDown.Name = "wallsnumericUpDown"; 
			this.wallsnumericUpDown.Size = new System.Drawing.Size(48, 21); 
			this.wallsnumericUpDown.TabIndex = 2;
			this.wallsnumericUpDown.Value = new System.Decimal(new int[]{20,0,0,0});
			this.wallsnumericUpDown.ValueChanged +=  new System.EventHandler(this.wallsnumericUpDown_ValueChanged);
			//
			// button2
			//
			this.button2.DialogResult = System.Windows.Forms.DialogResult.Cancel;
			this.button2.Location = new System.Drawing.Point(184, 160); 
			this.button2.Name = "button2";
			this.button2.Size = new System.Drawing.Size(72, 24); 
			this.button2.TabIndex = 1;
			this.button2.Text = "Cancle";
			//
			// numericUpDown1
			//
			this.numericUpDown1.Location = new System.Drawing.Point(184, 16); 
			this.numericUpDown1.Name = "numericUpDown1"; 
			this.numericUpDown1.Size = new System.Drawing.Size(64, 21); 
			this.numericUpDown1.TabIndex = 2;
			this.numericUpDown1.Value = new System.Decimal(new int[] {16,0,0,0});
			//
			// numericUpDown2
			//
			this.numericUpDown2.Location = new System.Drawing.Point(192,64); 
			this.numericUpDown2.Name = "numericUpDown2"; 
			this.numericUpDown2.Size = new System.Drawing.Size(56, 21); 
			this.numericUpDown2.TabIndex = 2;
			this.numericUpDown2.Value = new System.Decimal(new int[] {30,0,0,0});
			//
			// label4
			//
			this.label4.Location = new System.Drawing.Point(40, 64); 
			this.label4.Name = "label4";
			this.label4.Size = new System.Drawing.Size(120, 18); 
			this.label4.TabIndex = 6;
			this.label4.Text = "宫格大小(像素):";
			//
			// label5
			//
			this.label5.Location = new System.Drawing.Point(40, 24); 
			this.label5.Name = "label5";
			this.label5.Size = new System.Drawing.Size(120, 18); 
			this.label5.TabIndex = 5;
			this.label5.Text = "迷宫的阶数(n×n):";
			//
			// label1
			//
			this.label1.Location = new System.Drawing.Point(40, 112); 
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(120, 18); 
			this.label1.TabIndex = 7;
			this.label1.Text = "墙的比率(最好>20)";
			//
			// RandomMaze
			//
			this.AutoScaleBaseSize = new System.Drawing.Size(6, 14); 
			this.ClientSize = new System.Drawing.Size(304, 221); 
			this.Controls.Add(this.label1); 
			this.Controls.Add(this.label4); 
			this.Controls.Add(this.label5); 
			this.Controls.Add(this.wallsnumericUpDown); 
			this.Controls.Add(this.button1); 
			this.Controls.Add(this.button2); 
			this.Controls.Add(this.numericUpDown1); 
			this.Controls.Add(this.numericUpDown2);
			this.Name = "RandomMaze";
			this.Text = "RandomMaze";
			((System.ComponentModel.ISupportInitialize)(this.wallsnumericUpDown)).EndInit();
			((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).EndInit() ;
			((System.ComponentModel.ISupportInitialize)(this.numericUpDown2)).EndInit() ;
			this.ResumeLayout(false);
		}
		#endregion
		private void wallsnumericUpDown_ValueChanged(object sender, System.EventArgs e)
		{
		} 
	}

	//YY: Cell
	class Cell
	{
		public static int kCellSize = 30;//迷宫格子(宫格)的大小
		public static int kPadding = 1;//边界大小
		public int[] Walls = new int[4]{1, 1, 1, 1};//每个宫格都可以有四堵墙 public int Row;
		public int Column;
		private static long Seed = DateTime.Now.Ticks;//用当前时间来当随机种子
		static public Random TheRandom = new Random((int)Cell.Seed);//静态变量,只能用类来调用,不能用对象!
		public int Visited = 0;//搜索标记
		public int Pathmark = 0;//路径标记 
		public Cell parent = null;//路径“指针”

		public Cell()
		 {
			//
			// TODO: Add constructor logic here
			//
		}

		public bool HasAllWalls() 
		{
			for (int i = 0; i < 4; i++)
			{
				if (Walls[i] == 0)
				return false;
			}
			return true; 
		}


		public void KnockDownWall(int theWall) 
		{
			Walls[theWall] = 0; 
		}
		public void KnockDownWall(Cell theCell) 
		{
			// find adjacent wall 
			//每次敲墙,其实都要敲两堵——相邻宫格的重合的两堵墙
			int theWallToKnockDown = FindAdjacentWall(theCell); 
			Walls[theWallToKnockDown] = 0;
			int oppositeWall = (theWallToKnockDown + 2) % 4;
			theCell.Walls[oppositeWall] = 0;
		}

		public int FindAdjacentWall(Cell theCell) 
		{
			/* 返回给 walls[]用 *1
			*
			*↑
			*
			*0 ←cell→ 2 *
			*↓
			*
			*3
			*/
			if (theCell.Row == Row) 
			{
				if (theCell.Column < Column) 
				return 0;
				else
				return 2;
			}
			else // columns are the same
			{
				if (theCell.Row < Row)
				return 1;
				else
				return 3;
			} 
		}

		public int GetRandomWall() 
		{
			//墙已经敲开、以及到达四个边界时,再随机改个方向
			int nextWall = TheRandom.Next(0, 3);
			while （ (Walls[nextWall] == 0) || ((Row == 0) && (nextWall == 0)) ||
			((Row == Maze.kDimension - 1) && (nextWall == 2)) || ((Column == 0) && (nextWall == 1)) ||
			((Column == Maze.kDimension - 1) && (nextWall == 3)) )
			{
				nextWall = TheRandom.Next(0, 3); 
			}

			return nextWall;

		}

		public void Draw(Graphics g) 
		{
			Pen fillPen = null;
			fillPen = new Pen( Color.Tomato,2);//画墙的 Pen,颜色为 Tomato,粗度为2
			if (Walls[0] == 1)
			{
				g.DrawLine(fillPen, Row*kCellSize + kPadding, Column*kCellSize + kPadding, (Row+1) * kCellSize + kPadding, Column*kCellSize + kPadding);
			}
			if (Walls[1] == 1)
			{
				g.DrawLine(fillPen,Row*kCellSize +kPadding,Column*kCellSize+ kPadding, Row*kCellSize + kPadding, (Column+1)*kCellSize + kPadding);
			}
			if (Walls[2] == 1)
			{
				g.DrawLine(fillPen, Row*kCellSize + kPadding, (Column+1)*kCellSize + kPadding, (Row+1)*kCellSize + kPadding,(Column+1)*kCellSize + kPadding);
			}
			if (Walls[3] == 1)
			{
				g.DrawLine(fillPen,(Row+1)*kCellSize + kPadding,Column*kCellSize + kPadding, (Row+1)*kCellSize + kPadding, (Column+1)*kCellSize + kPadding);
			}
		}

		public void DrawFill(Graphics g)
		{
			int blank = kCellSize/8;
			SolidBrush fillBrush = new SolidBrush(Color.Tomato);
			g.FillRectangle(fillBrush,Row*kCellSize + kPadding+blank,Column*kCellSize + kPadding+blank,kCellSize-blank*2,kCellSize-blank*2);
			Pathmark = 5;//为路径重绘准备,番茄色
		}

		public void DrawFillSearch(Graphics g) 
		{
			int blank = kCellSize/8;
			SolidBrush fillBrush = new SolidBrush(Color.Gray);
			g.FillRectangle(fillBrush,Row*kCellSize + kPadding+blank, Column*kCellSize + kPadding+blank,kCellSize-blank*2,kCellSize-blank*2);
			Pathmark = 1;//为搜索点重绘准备,灰色
		}

		public void DrawFillNull(Graphics g) 
		{
			int blank = kCellSize/8;
			SolidBrush fillBrush = new SolidBrush(Color.White);
			g.FillRectangle(fillBrush,Row*kCellSize + kPadding+blank,Column*kCellSize + kPadding+blank,kCellSize-blank*2,kCellSize-blank*2);
			Pathmark = 0;//为空白重绘准备,白色
		}
	}


	//YY:Form
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
 				public class Form1 : System.Windows.Forms.Form 
 				{
 					private System.ComponentModel.IContainer components; 
 					private System.Windows.Forms.MainMenu mainMenu1; 
 					private System.Windows.Forms.MenuItem menuItem1; 
 					private System.Windows.Forms.MenuItem DimensionsMenu; 
 					private System.Windows.Forms.MenuItem menuItem2; 
 					private System.Windows.Forms.MenuItem menuItem5; 
 					private System.Windows.Forms.MenuItem menuItem6; 
 					private System.Windows.Forms.MenuItem menuItem7; 
 					private System.Windows.Forms.MenuItem menuItem3; 
 					private System.Windows.Forms.MenuItem menuItem4; 
 					private System.Windows.Forms.MenuItem menuItem8; 
 					private Maze TheMaze = new Maze();
 					private System.Windows.Forms.MenuItem menuItem9; 
 					private System.Windows.Forms.MenuItem menuItem10;

 					private int delayS = 20;
		private MenuItem menuItem11;//搜索显示延时 
		private int delayP = 20;//路径显示延时

		public Form1()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();
			SetBounds(this.Left, this.Top, ( Maze.kDimension + 1 )* Cell.kCellSize+ 2 * Cell.kPadding ,( Maze.kDimension + 3) * Cell.kCellSize + 2 * Cell.kPadding);
			this.Cursor = Cursors.WaitCursor;
			TheMaze.Generate(); 
			this.Cursor = Cursors.Arrow;

			//
			// TODO: Add any constructor code after InitializeComponent call
			//

		}

		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		protected override void Dispose( bool disposing ) 
		{
			if( disposing )
			{
				if (components != null) 
				{
					components.Dispose(); 
				}
			}
			base.Dispose( disposing ); 
		}

		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify 
		/// the contents of this method with the code editor. 
		/// </summary>
		private void InitializeComponent()
		{
			this.components = new System.ComponentModel.Container();
			System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
			this.mainMenu1 = new System.Windows.Forms.MainMenu(this.components); 
			this.menuItem1 = new System.Windows.Forms.MenuItem(); 
			this.DimensionsMenu = new System.Windows.Forms.MenuItem();
			this.menuItem9 = new System.Windows.Forms.MenuItem(); 
			this.menuItem10 = new System.Windows.Forms.MenuItem(); 
			this.menuItem2 = new System.Windows.Forms.MenuItem();
			this.menuItem5 = new System.Windows.Forms.MenuItem(); 
			this.menuItem6 = new System.Windows.Forms.MenuItem(); 
			this.menuItem7 = new System.Windows.Forms.MenuItem();
			this.menuItem3 = new System.Windows.Forms.MenuItem(); 
			this.menuItem4 = new System.Windows.Forms.MenuItem(); 
			this.menuItem8 = new System.Windows.Forms.MenuItem(); 
			this.menuItem11 = new System.Windows.Forms.MenuItem();
			this.SuspendLayout();
			//
			// mainMenu1
			//
			this.mainMenu1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] 
				{ this.menuItem1,this.menuItem2, this.menuItem3});
			//
			// menuItem1
			//
			this.menuItem1.Index = 0;
			this.menuItem1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[]
				{this.DimensionsMenu,this.menuItem9,this.menuItem10});
			this.menuItem1.Text = "初始化";
			//
			// DimensionsMenu
			//
			this.DimensionsMenu.Index = 0; 
			this.DimensionsMenu.Text = "生成完美迷宫..";
			this.DimensionsMenu.Click += new System.EventHandler(this.DimensionsMenu_Click);
			//
			// menuItem9
			//
			this.menuItem9.Index = 1;
			this.menuItem9.Text = "生成随机迷宫...";
			this.menuItem9.Click += new System.EventHandler(this.menuItem9_Click);
			//
			// menuItem10
			//
			this.menuItem10.Index = 2; 
			this.menuItem10.Text = "搜索演示设置.";
			this.menuItem10.Click += new System.EventHandler(this.menuItem10_Click);
			//
			// menuItem2
			//
			this.menuItem2.Index = 1;
			this.menuItem2.MenuItems.AddRange(newSystem.Windows.Forms.MenuItem[] 
				{ this.menuItem5,this.menuItem6,this.menuItem7, this.menuItem11});
			this.menuItem2.Text = "选择算法";
			//
			// menuItem5
			//
			this.menuItem5.Index = 0; 
			this.menuItem5.Text = "深度搜索";
			this.menuItem5.Click += new System.EventHandler(this.menuItem5_Click);
			//
			// menuItem6
			//
			this.menuItem6.Index = 1;
			this.menuItem6.Text = "广度搜索";
			this.menuItem6.Click += new System.EventHandler(this.menuItem6_Click);
			//
			// menuItem7
			//
			//
			this.menuItem7.Index = 1;
			this.menuItem7Text = "启发式搜索"；
			this.menuItem7.Click += new System.EventHandler(this.menuItem7_Click);
			//
			// menuItem8
			//
			this.menuItem8.Index = 1; 
			this.menuItem8.Text = "遗传搜索";
			this.menuItem8.Click += new System.EventHandler(this.menuItem8_Click);
			//
			// menuItem3
			//
			this.menuItem3.Index = 2;
			this.menuItem3.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] 
				{this.menuItem4, this.menuItem8});
			this.menuItem3.Text = "退出"; 
			//
			// menuItem4
			//
			this.menuItem4.Index = 0; 
			this.menuItem4.Text = "离开迷宫";
			this.menuItem4.Click += new System.EventHandler(this.menuItem4_Click);
			//
			// menuItem8
			//
			this.menuItem8.Index = 1; 
			this.menuItem8.Text = "About p_Sa";
			this.menuItem8.Click += new System.EventHandler(this.menuItem8_Click);
			//
			// menuItem11
			//
			this.menuItem11.Index = 3; 
			this.menuItem11.Text = "遗传搜索";
			//
			// Form1
			//
			this.AutoScaleBaseSize = new System.Drawing.Size(6, 14); 
			this.ClientSize = new System.Drawing.Size(350, 294);
			this.Icon =((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.Menu = this.mainMenu1;
			this.Name = "Form1";
			this.Text = "20082792 迷宫";
			this.Load += new System.EventHandler(this.Form1_Load);
			this.Paint += new System.Windows.Forms.PaintEventHandler(this.Form1_Paint);
			this.ResumeLayout(false);
		}

		#endregion

		/// <summary>
		/// The main entry point for the application.
		/// </summary>
		[STAThread]
		static void Main() 
		{
			Application.Run(new Form1()); 
		}
		private void Form1_Paint (object sender,System.Windows.Forms.PaintEventArgs e)
		{
			Graphics g = e.Graphics; 
			g.FillRectangle(Brushes.White, ClientRectangle); 
			TheMaze.Draw(g);//重绘墙
			TheMaze.reDraw(g);//重绘路,解决菜单遮挡迷宫路径等显示问题 
		}

		//完美迷宫
		private void DimensionsMenu_Click(object sender, System.EventArgs e)
		{
			DimensionsDialog theDialog = new DimensionsDialog(); 
			theDialog.numericUpDown1.Value = Maze.kDimension; 
			theDialog.numericUpDown2.Value = Cell.kCellSize;
			if (theDialog.ShowDialog() == DialogResult.OK)
			{
				Maze.kDimension = (int)theDialog.numericUpDown1.Value; 
				Cell.kCellSize = (int)theDialog.numericUpDown2.Value;
				TheMaze.Initialize();
				TheMaze.Generate();
				SetBounds(this.Left, this.Top, (Maze.kDimension + 2) *Cell.kCellSize + Cell.kPadding, (Maze.kDimension + 5) * Cell.kCellSize +Cell.kPadding);
				Invalidate();//......
			}
		}

		//随机迷宫
		private void menuItem9_Click(object sender, System.EventArgs e)
		{
			RandomMaze theRandom = new RandomMaze(); 
			theRandom.numericUpDown1.Value = 16;
			theRandom.numericUpDown2.Value = 30; 
			theRandom.wallsnumericUpDown.Value = 20;
			if(theRandom.ShowDialog() == DialogResult.OK)
			{
				Maze.kDimension = (int)theRandom.numericUpDown1.Value; 
				Cell.kCellSize = (int)theRandom.numericUpDown2.Value; 
				Maze.wallsrate = (int)theRandom.wallsnumericUpDown.Value;

				TheMaze.Initialize();
				TheMaze.GenerateRandom();
				SetBounds(this.Left, this.Top, (Maze.kDimension + 2) *Cell.kCellSize + Cell.kPadding, (Maze.kDimension + 5) * Cell.kCellSize +Cell.kPadding);
				Invalidate();//......
			}
		}

		//搜索演示设置
		private void menuItem10_Click(object sender, System.EventArgs e) 
		{
			setting theset = new setting(); 
			if(theset.ShowDialog() == DialogResult.OK) 
			{
				if(theset.checkBox1.Checked == true)//注意要用== 
				delayS = (int)theset.numericUpDown1.Value;
				else
				delayS = 0;
				if(theset.checkBox2.Checked == true)
				delayP = (int)theset.numericUpDown2.Value;
				else
				delayP = 0;
			} 
		}

		//copyright...
		private void menuItem8_Click(object sender, System.EventArgs e)
		{
			 MessageBox.Show(this,//"!时间—summer.2011\n ◎地点—北京\n #人物 —20082792.陈强\n ¥事件 — 迷宫搜索\n", "\n!时间 — summer.2011\n\n◎地点 — 北京\n\n#人物 — 20082792. 陈强\n\n¥事件 — 迷宫搜索\n\n",
			 	"p_Sa.software | A.I.Maze0.1",
			 	MessageBoxButtons.OK, 
			 	MessageBoxIcon.Asterisk, 
			 	MessageBoxDefaultButton.Button1);

			}
		//退出程序
			private void menuItem4_Click(object sender, System.EventArgs e) 
			{
				Application.Exit(); 
			}

			private void menuItem5_Click(object sender, System.EventArgs e)
			{
			//深度搜索
				Graphics g = this.CreateGraphics(); 
				TheMaze.clearSearch(g);
				if(TheMaze.DFSearch())
				{
					DrawTogether(); 
				}
				else
				{
					MessageBox.Show("搜索失败-深度"); 
				}
			//this.Refresh(); 
			//this.Invalidate();
			}

			private void menuItem6_Click(object sender, System.EventArgs e)
			{
			//广度搜索
				Graphics g = this.CreateGraphics(); 
				TheMaze.clearSearch(g);
				if(TheMaze.BFSearch())
				{
					DrawTogether(); 
				}
				else 
				{
					MessageBox.Show("搜索失败-广度");
				} 
			}

			private void menuItem7_Click(object sender, System.EventArgs e) 
			{
			//启发搜索(A*)
				Graphics g = this.CreateGraphics(); 
				TheMaze.clearSearch(g);
				if(TheMaze.AISearch())
				{
					DrawTogether(); 
				}
				else {
					MessageBox.Show("搜索失败-A*"); 
				}
			}


		//三个搜索的共同代码,提出成函数
			private void DrawTogether()
			{
				if(TheMaze.CLOSED.Count != 0)
				{
					for(int i=0;i<TheMaze.CLOSED.Count;i++)
					{
						Cell PathCell =( Cell)TheMaze.CLOSED[i];
						Graphics g = this.CreateGraphics(); 
						PathCell.DrawFillSearch(g);
					System.Threading.Thread.Sleep(delayS);//画搜索格子,每格都会s延时 delayS
				}
			}

			while(TheMaze.PathStack.Count != 0)
			{
				Cell PathCell = (Cell)TheMaze.PathStack.Pop();
				Graphics g = this.CreateGraphics();
				PathCell.DrawFill(g);
				System.Threading.Thread.Sleep(delayP);//画路径格子,每格都会延时 delayP
			}
		}
		private void Form1_Load(object sender, EventArgs e) {
		} 
	}
}
















